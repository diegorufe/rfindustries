package com.rfindustries.commons.service.impl;

import com.rfindustries.commons.dao.TaxVersionDao;
import com.rfindustries.commons.dto.TaxVersionDTO;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.service.TaxVersionService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TaxVersionServiceImpl extends BaseTransactionalCrudServiceImpl<TaxVersionDao, TaxVersionEntity, Long, TaxVersionDTO>
        implements TaxVersionService {

    @Override
    public TaxVersionEntity toEntity(TaxVersionDTO dto) {
        return TaxVersionEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .startDate(dto.getStartDate())
                .type(dto.getType() == null ? null : dto.getType().getType())
                .value(dto.getValue())
                .build();
    }

    @Override
    public TaxVersionDTO toDTO(TaxVersionEntity entity) {
        return TaxVersionDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .startDate(entity.getStartDate())
                .type(TaxVersionType.findByType(entity.getType()))
                .value(entity.getValue())
                .build();
    }

    @Override
    public TaxVersionDTO instanceDTO() {
        return TaxVersionDTO.builder().build();
    }

    @Override
    public Optional<TaxVersionDTO> findTaxVersionByTaxIdAndDate(Long taxId, LocalDate startDate) {
        TaxVersionDTO result = null;

        if(taxId != null && startDate != null){
            result  = TaxVersionDTO.fromTaxVersionWithTaxMapping(this.getDao().findTaxVersionByTaxIdAndDate(taxId, startDate));
        }

        return Optional.ofNullable(result);
    }
}
