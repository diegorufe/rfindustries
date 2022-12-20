package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.dto.AccountingYearDTO;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.dto.LedgerAccountDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.service.InvoiceHeaderService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InvoiceHeaderServiceImpl extends BaseTransactionalCrudServiceImpl<InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO>
        implements InvoiceHeaderService {

    @Override
    public InvoiceHeaderEntity toEntity(InvoiceHeaderDTO dto) {
        return InvoiceHeaderEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .code(dto.getCode())
                .number(dto.getNumber())
                .dateTime(dto.getDateTime())
                .accountingId(dto.getAccounting() == null ? null : dto.getAccounting().getId())
                .accountingYearId(dto.getAccountingYear() == null ? null : dto.getAccountingYear().getId())
                .ledgerAccountId(dto.getLedgerAccount() == null ? null : dto.getLedgerAccount().getId())
                .build();
    }

    @Override
    public InvoiceHeaderDTO toDTO(InvoiceHeaderEntity entity) {
        return InvoiceHeaderDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .code(entity.getCode())
                .number(entity.getNumber())
                .dateTime(entity.getDateTime())
                .accounting(AccountingDTO.builder().id(entity.getAccountingId()).build())
                .accountingYear(AccountingYearDTO.builder().id(entity.getAccountingYearId()).build())
                .ledgerAccount(LedgerAccountDTO.builder().id(entity.getLedgerAccountId()).build())
                .build();
    }
}
