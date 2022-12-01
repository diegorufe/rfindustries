package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.AccountingYearDao;
import com.rfindustries.accounting.dto.AccountingYearDTO;
import com.rfindustries.accounting.entities.AccountingYearEntity;
import com.rfindustries.accounting.service.AccountingYearService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountingYearServiceImpl extends BaseTransactionalCrudServiceImpl<AccountingYearDao, AccountingYearEntity, Long, AccountingYearDTO>
        implements AccountingYearService {

    @Override
    public AccountingYearEntity toEntity(AccountingYearDTO dto) {
        return AccountingYearEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .code(dto.getCode())
                .name(dto.getName())
                .accountingId(dto.resolveAccountingId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }

    @Override
    public AccountingYearDTO toDTO(AccountingYearEntity entity) {
        return AccountingYearDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .code(entity.getCode())
                .name(entity.getName())
                .accountingId(entity.getAccountingId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }
}
