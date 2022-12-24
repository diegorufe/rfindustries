package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.LedgerAccountDao;
import com.rfindustries.accounting.dto.LedgerAccountDTO;
import com.rfindustries.accounting.entities.LedgerAccountEntity;
import com.rfindustries.accounting.service.LedgerAccountService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LedgerAccountServiceImpl extends BaseTransactionalCrudServiceImpl<LedgerAccountDao, LedgerAccountEntity, Long, LedgerAccountDTO>
        implements LedgerAccountService {

    @Override
    public LedgerAccountEntity toEntity(LedgerAccountDTO dto) {
        return LedgerAccountEntity.builder()
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
    public LedgerAccountDTO toDTO(LedgerAccountEntity entity) {
        return LedgerAccountDTO.builder()
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

    @Override
    public LedgerAccountDTO instanceDTO() {
        return LedgerAccountDTO.builder().build();
    }
}
