package com.rfindustries.commons.service.impl;

import com.rfindustries.commons.dao.TaxVersionDao;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.service.TaxVersionService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import org.springframework.stereotype.Service;

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
                .startTime(dto.getStartTime())
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
                .startTime(entity.getStartTime())
                .type(TaxVersionType.findByType(entity.getType()))
                .value(entity.getValue())
                .build();
    }

    @Override
    public TaxVersionDTO instanceDTO() {
        return TaxVersionDTO.builder().build();
    }
}
