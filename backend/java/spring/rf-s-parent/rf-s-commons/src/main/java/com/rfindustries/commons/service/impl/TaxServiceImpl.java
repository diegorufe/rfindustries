package com.rfindustries.commons.service.impl;

import com.rfindustries.commons.dao.TaxDao;
import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.commons.service.TaxService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl extends BaseTransactionalCrudServiceImpl<TaxDao, TaxEntity, Long, TaxDTO>
        implements TaxService {

    @Override
    public TaxEntity toEntity(TaxDTO dto) {
        return TaxEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .code(dto.getCode())
                .name(dto.getName())
                .build();
    }

    @Override
    public TaxDTO toDTO(TaxEntity entity) {
        return TaxDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }
}
