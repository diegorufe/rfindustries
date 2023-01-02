package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.BigDecimalUtils;
import com.rf.collections.utils.CollectionUtils;
import com.rf.collections.utils.StringUtils;
import com.rfindustries.accounting.cache.CacheManager;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import com.rfindustries.shared.commons.service.TaxVersionGrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class InvoiceLineServiceImpl extends BaseTransactionalCrudServiceImpl<InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO>
        implements InvoiceLineService {

    @Autowired
    private TaxVersionGrpcService taxVersionGrpcService;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public InvoiceLineEntity toEntity(BaseCommonsParameters baseCommonsParameters, InvoiceLineDTO dto) {
        return AccountingMapperUtils.toInvoiceLineEntity(dto);
    }

    @Override
    public InvoiceLineDTO toDTO(BaseCommonsParameters baseCommonsParameters, InvoiceLineEntity entity) {
        return this.entitiesToDTOs(baseCommonsParameters, List.of(entity)).get(0);
    }

    @Override
    public InvoiceLineDTO instanceDTO() {
        return InvoiceLineDTO.builder().amount(BigDecimal.ZERO).total(BigDecimal.ZERO).build();
    }

    @Override
    public List<InvoiceLineDTO> findAllByInvoiceId(BaseCommonsParameters baseCommonsParameters, Long invoiceId) {
        return this.getDao().findAllByInvoiceId(invoiceId);
    }

    private List<InvoiceLineDTO> entitiesToDTOs(BaseCommonsParameters baseCommonsParameters, List<InvoiceLineEntity> entities) {
        List<InvoiceLineDTO> result = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(entities)) {
            final Map<Long, TaxVersionDTO> mapTaxVersion = new HashMap<>();
            result = entities.stream().map(e -> {
                InvoiceLineDTO dto = AccountingMapperUtils.toInvoiceLineDTO(e);
                this.resolveTagVersions(baseCommonsParameters, dto, mapTaxVersion, e.getTaxVersions());
                return dto;
            }).toList();
        }

        return result;
    }

    private void resolveTagVersions(BaseCommonsParameters baseCommonsParameters, InvoiceLineDTO dto, final Map<Long, TaxVersionDTO> mapTaxVersion, String taxVersions) {
        final Set<TaxVersionDTO> taxVersionsLine = new LinkedHashSet<>();

        if (StringUtils.isNotBlank(taxVersions)) {
            Set<Long> ids = this.filterIdsTaxVersions(baseCommonsParameters, mapTaxVersion, taxVersionsLine, taxVersions);

            if (CollectionUtils.isNotEmpty(ids)) {
                Set<TaxVersionDTO> taxVersionFind = this.taxVersionGrpcService.findTaxVersionsByIds(ids);

                if (CollectionUtils.isNotEmpty(taxVersionFind)) {
                    taxVersionFind.forEach(v -> {
                        mapTaxVersion.put(v.getId(), v);
                        taxVersionsLine.add(v);
                        this.cacheManager.putTaxVersion(baseCommonsParameters, v);
                    });
                }
            }


        }

        dto.setTaxVersions(taxVersionsLine);

    }

    private Set<Long> filterIdsTaxVersions(BaseCommonsParameters baseCommonsParameters, final Map<Long, TaxVersionDTO> mapTaxVersion, final Set<TaxVersionDTO> taxVersionsLine, String taxVersionsIds) {
        return StringUtils.idsHashtagsToSet(taxVersionsIds, Long::parseLong).stream().filter(id -> {
            boolean valid = true;

            if (mapTaxVersion.containsKey(id)) {
                taxVersionsLine.add(mapTaxVersion.get(id));
                valid = false;
            } else {
                Optional<TaxVersionDTO> op = this.cacheManager.findTaxVersion(baseCommonsParameters, id);

                if (op.isPresent()) {
                    mapTaxVersion.put(id, op.get());
                    taxVersionsLine.add(op.get());
                }
            }

            return valid;
        }).collect(Collectors.toSet());
    }

    @Override
    public <HEADER_PK> List<InvoiceLineDTO> findByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return this.findAllByInvoiceId(baseCommonsParameters, (Long) headerPk);
    }

    @Transactional
    @Override
    public <HEADER_PK> long deleteByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return this.deleteAllByInvoiceId(baseCommonsParameters, (Long) headerPk);
    }

    @Transactional
    @Override
    public long deleteAllByInvoiceId(BaseCommonsParameters baseCommonsParameters, Long invoiceId) {
        return this.getDao().deleteAllByInvoiceId(invoiceId);
    }

    @Override
    public void calculateTotal(BaseCommonsParameters baseCommonsParameters, InvoiceLineDTO dto) {
        if (dto != null) {
            dto.setTotal(BigDecimal.ZERO);

            if (dto.getAmount() == null) {
                dto.setAmount(BigDecimal.ZERO);
            }

            dto.setAmount(BigDecimalUtils.scale(dto.getAmount(), baseCommonsParameters.getPrecisionOperation().getAmount()));

            if (dto.getAmount().compareTo(BigDecimal.ZERO) > 0 && CollectionUtils.isNotEmpty(dto.getTaxVersions())) {

                dto.getTaxVersions().forEach(tv -> {
                    switch (tv.getType()) {
                        case AMOUNT -> {
                            BigDecimal total = BigDecimalUtils.scale(tv.getValue(), baseCommonsParameters.getPrecisionOperation().getTotal());
                            dto.setTotal(BigDecimalUtils.add(dto.getTotal(), total));
                        }

                        case RATE -> {
                            BigDecimal total = BigDecimalUtils.scale(BigDecimalUtils.multiply(dto.getAmount(), BigDecimalUtils.percent(tv.getValue())), baseCommonsParameters.getPrecisionOperation().getTotal());
                            dto.setTotal(BigDecimalUtils.add(dto.getTotal(), total));
                        }
                    }
                });
            }

            dto.setTotal(BigDecimalUtils.scale(dto.getTotal(), baseCommonsParameters.getPrecisionOperation().getAmount()));
        }
    }

    @Override
    public void recalculate(BaseCommonsParameters baseCommonsParameters, InvoiceLineDTO dto) {
        Set<TaxVersionDTO> taxVersions = dto.getTaxVersions();

        if (CollectionUtils.isNotEmpty(taxVersions)) {
            final Map<Long, TaxVersionDTO> mapTaxVersion = new HashMap<>();
            StringBuilder builder = new StringBuilder();
            taxVersions.forEach(tv -> builder.append(StringUtils.createHashtag(tv.getId().toString())));
            this.resolveTagVersions(baseCommonsParameters, dto, mapTaxVersion, builder.toString());
        }

        this.calculateTotal(baseCommonsParameters, dto);
    }
}
