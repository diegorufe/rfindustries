package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dao.TaxDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.dto.TaxDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.accounting.entities.TaxEntity;
import com.rfindustries.accounting.service.AccountingService;
import com.rfindustries.accounting.service.TaxService;
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
                .startDate(dto.getStartDate())
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
                .startDate(entity.getStartDate())
                .build();
    }
}
