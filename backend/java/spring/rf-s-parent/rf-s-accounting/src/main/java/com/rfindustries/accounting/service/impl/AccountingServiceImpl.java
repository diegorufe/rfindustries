package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.accounting.service.AccountingService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountingServiceImpl extends BaseTransactionalCrudServiceImpl<AccountingDao, AccountingEntity, Long, AccountingDTO>
        implements AccountingService {

    @Override
    public AccountingEntity toEntity(AccountingDTO dto) {
        return AccountingMapperUtils.toAccountingEntity(dto);
    }

    @Override
    public AccountingDTO toDTO(AccountingEntity entity) {
        return AccountingMapperUtils.toAccountingDTO(entity);
    }

    @Override
    public AccountingDTO instanceDTO() {
        return AccountingDTO.builder().build();
    }
}
