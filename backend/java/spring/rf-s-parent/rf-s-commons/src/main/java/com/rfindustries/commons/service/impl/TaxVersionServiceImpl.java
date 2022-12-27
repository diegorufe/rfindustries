package com.rfindustries.commons.service.impl;

import com.rfindustries.commons.dao.TaxVersionDao;
import com.rfindustries.commons.dto.TaxVersionDTO;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.service.TaxVersionService;
import com.rfindustries.commons.utils.CommonsMapperUtils;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.rfindustries.commons.utils.CommonsMapperUtils.fromTaxVersionWithTaxEntity;


@Service
public class TaxVersionServiceImpl extends BaseTransactionalCrudServiceImpl<TaxVersionDao, TaxVersionEntity, Long, TaxVersionDTO>
        implements TaxVersionService {

    @Override
    public TaxVersionEntity toEntity(TaxVersionDTO dto) {
        return CommonsMapperUtils.toTaxVersionEntity(dto);
    }

    @Override
    public TaxVersionDTO toDTO(TaxVersionEntity entity) {
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
}
