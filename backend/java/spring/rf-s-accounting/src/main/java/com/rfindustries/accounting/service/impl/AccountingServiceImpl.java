package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.accounting.service.AccountingService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountingServiceImpl extends BaseTransactionalCrudServiceImpl<AccountingDao, AccountingEntity, Long, AccountingDTO>
        implements AccountingService {

    @Override
    public AccountingEntity toEntity(AccountingDTO dto) {
        return AccountingEntity.builder()
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
    public AccountingDTO toDTO(AccountingEntity entity) {
        return AccountingDTO.builder()
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
