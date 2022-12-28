package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rf.collections.utils.StringUtils;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
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

    @Override
    public InvoiceLineEntity toEntity(InvoiceLineDTO dto) {
        return AccountingMapperUtils.toInvoiceLineEntity(dto);
    }

    @Override
    public InvoiceLineDTO toDTO(InvoiceLineEntity entity) {
        return this.entitiesToDTOs(List.of(entity)).get(0);
    }

    @Override
    public InvoiceLineDTO instanceDTO() {
        return InvoiceLineDTO.builder().build();
    }

    @Override
    public List<InvoiceLineDTO> findAllByInvoiceId(Long invoiceId) {
        return this.entitiesToDTOs(this.getDao().findAllByInvoiceId(invoiceId));
    }

    private List<InvoiceLineDTO> entitiesToDTOs(List<InvoiceLineEntity> entities) {
        List<InvoiceLineDTO> result = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(entities)) {
            final Map<Long, TaxVersionDTO> mapTaxVersion = new HashMap<>();
            result = entities.stream().map(e -> {
                InvoiceLineDTO dto = AccountingMapperUtils.toInvoiceLineDTO(e);
                final Set<TaxVersionDTO> taxVersionsLine = new LinkedHashSet<>();

                if (StringUtils.isNotBlank(e.getTaxVersions())) {
                    Set<Long> ids = this.filterIdsTaxVersions(mapTaxVersion, taxVersionsLine, e.getTaxVersions());

                    if (CollectionUtils.isNotEmpty(ids)) {
                        Set<TaxVersionDTO> taxVersionFind = this.taxVersionGrpcService.findTaxVersionsByIds(ids);

                        if (CollectionUtils.isNotEmpty(taxVersionFind)) {
                            taxVersionFind.forEach(v -> {
                                mapTaxVersion.put(v.getId(), v);
                                taxVersionsLine.add(v);
                            });
                        }
                    }
                }


                dto.setTaxVersions(taxVersionsLine);

                return dto;
            }).toList();
        }

        return result;
    }

    private Set<Long> filterIdsTaxVersions(final Map<Long, TaxVersionDTO> mapTaxVersion, final Set<TaxVersionDTO> taxVersionsLine, String taxVersionsIds) {
        return StringUtils.idsHashtagsToSet(taxVersionsIds, Long::parseLong).stream().filter(id -> {
            boolean valid = true;

            if (mapTaxVersion.containsKey(id)) {
                taxVersionsLine.add(mapTaxVersion.get(id));
                valid = false;
            }

            return valid;
        }).collect(Collectors.toSet());
    }

    @Override
    public <HEADER_PK> List<InvoiceLineDTO> findByHeaderPk(HEADER_PK headerPk) {
        return this.findAllByInvoiceId((Long) headerPk);
    }

    @Transactional
    @Override
    public <HEADER_PK> long deleteByHeaderPk(HEADER_PK headerPk) {
        return this.deleteAllByInvoiceId((Long) headerPk);
    }

    @Transactional
    @Override
    public long deleteAllByInvoiceId(Long invoiceId) {
        return this.getDao().deleteAllByInvoiceId(invoiceId);
    }

    @Override
    public void calculateTotal(InvoiceLineDTO dto) {
        if(dto != null){
            dto.setTotal(BigDecimal.ZERO);

            if(dto.getAmount() == null){
                dto.setAmount(BigDecimal.ZERO);
            }

            if(dto.getAmount().compareTo(BigDecimal.ZERO) > 0 && CollectionUtils.isNotEmpty(dto.getTaxVersions())){

                dto.getTaxVersions().forEach(tv->{
                    // TODO
                });
            }
        }
    }
}
