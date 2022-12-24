package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.*;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import com.rfindustries.shared.accounting.InvoiceLineType;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import org.springframework.stereotype.Service;

@Service
public class InvoiceLineServiceImpl extends BaseTransactionalCrudServiceImpl<InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO>
        implements InvoiceLineService {

    @Override
    public InvoiceLineEntity toEntity(InvoiceLineDTO dto) {
        return InvoiceLineEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .invoiceHeaderId(dto.getInvoiceHeader() == null ? null : dto.getInvoiceHeader().getId())
                .ledgerAccountId(dto.getLedgerAccount() == null ? null : dto.getLedgerAccount().getId())
                .type(dto.getType().getType())
                .number(dto.getNumber())
                .amount(dto.getAmount())
                .total(dto.getTotal())
                .description(dto.getDescription())
                .taxVersions(TaxVersionDTO.taxVersionsToIds(dto.getTaxVersions()))
                .build();
    }

    @Override
    public InvoiceLineDTO toDTO(InvoiceLineEntity entity) {
        return InvoiceLineDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .invoiceHeader(InvoiceHeaderDTO.builder().id(entity.getInvoiceHeaderId()).build())
                .ledgerAccount(LedgerAccountDTO.builder().id(entity.getLedgerAccountId()).build())
                .type(InvoiceLineType.getByType(entity.getType()))
                .taxVersions(TaxVersionDTO.idsToTaxVersionDTOs(entity.getTaxVersions()))
                .build();
    }

    @Override
    public InvoiceLineDTO instanceDTO() {
        return InvoiceLineDTO.builder().build();
    }
}
