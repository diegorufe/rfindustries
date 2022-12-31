package com.rfindustries.commons.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.commons.dao.TaxVersionDao;
import com.rfindustries.commons.dto.TaxVersionDTO;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.entities.mappers.entities.TaxVersionWithTaxEntity;
import com.rfindustries.commons.service.TaxVersionService;
import com.rfindustries.commons.utils.CommonsMapperUtils;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rfindustries.commons.utils.CommonsMapperUtils.fromTaxVersionWithTaxEntity;


@Service
public class TaxVersionServiceImpl extends BaseTransactionalCrudServiceImpl<TaxVersionDao, TaxVersionEntity, Long, TaxVersionDTO>
        implements TaxVersionService {

    @Override
    public TaxVersionEntity toEntity(BaseCommonsParameters baseCommonsParameters, TaxVersionDTO dto) {
        return CommonsMapperUtils.toTaxVersionEntity(dto);
    }

    @Override
    public TaxVersionDTO toDTO(BaseCommonsParameters baseCommonsParameters, TaxVersionEntity entity) {
        return CommonsMapperUtils.toTaxVersionDTO(entity);
    }

    @Override
    public TaxVersionDTO instanceDTO() {
        return TaxVersionDTO.builder().build();
    }

    @Override
    public Optional<TaxVersionDTO> findTaxVersionByTaxIdAndDate(Long taxId, LocalDate startDate) {
        TaxVersionDTO result = null;

        if (taxId != null && startDate != null) {
            result = fromTaxVersionWithTaxEntity(this.getDao().findTaxVersionByTaxIdAndDate(taxId, startDate));
        }

        return Optional.ofNullable(result);
    }

    @Override
    public Set<TaxVersionDTO> findTaxVersionsByIds(Set<Long> ids) {
        Set<TaxVersionDTO> result = new LinkedHashSet<>();

        if (CollectionUtils.isNotEmpty(ids)) {
            List<TaxVersionWithTaxEntity> entities = this.getDao().findTaxVersionsByIds(ids);

            if (CollectionUtils.isNotEmpty(entities)) {
                result = entities.stream().map(CommonsMapperUtils::fromTaxVersionWithTaxEntity).collect(Collectors.toSet());
            }

        }

        return result;
    }
}
