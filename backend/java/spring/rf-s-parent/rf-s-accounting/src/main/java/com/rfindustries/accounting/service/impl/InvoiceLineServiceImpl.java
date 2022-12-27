package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.dto.LedgerAccountDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import com.rfindustries.shared.accounting.InvoiceLineType;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
                .dateTime(dto.getDateTime())
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
                .dateTime(entity.getDateTime())
                .type(InvoiceLineType.getByType(entity.getType()))
                .taxVersions(TaxVersionDTO.idsToTaxVersionDTOs(entity.getTaxVersions()))
                .build();
    }

    @Override
    public InvoiceLineDTO instanceDTO() {
        return InvoiceLineDTO.builder().build();
    }

    @Override
    public List<InvoiceLineDTO> findAllByInvoiceId(Long invoiceId) {
        List<InvoiceLineDTO> result = new ArrayList<>();

        if (invoiceId != null) {
            List<InvoiceLineEntity> entities = this.getDao().findAllByInvoiceId(invoiceId);

            if (CollectionUtils.isNotEmpty(entities)) {
                result = entities.stream().map(this::toDTO).toList();
            }
        }

        // TODO find tax versions dtos

        return result;
    }

    @Override
    public <HEADER_PK> List<InvoiceLineDTO> findByHeaderPk(HEADER_PK headerPk) {
        return this.findAllByInvoiceId((Long) headerPk);
    }

    @Transactional
    @Override
    public <HEADER_PK> long deleteByHeaderPk(HEADER_PK headerPk) {
        return this.deleteAllByInvoiceId((Long) headerPk);
    }

    @Transactional
    @Override
    public long deleteAllByInvoiceId(Long invoiceId) {
        return this.getDao().deleteAllByInvoiceId(invoiceId);
    }
}
