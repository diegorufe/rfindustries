package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.AccountingYearDao;
import com.rfindustries.accounting.dto.AccountingYearDTO;
import com.rfindustries.accounting.entities.AccountingYearEntity;
import com.rfindustries.accounting.service.AccountingYearService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountingYearServiceImpl extends BaseTransactionalCrudServiceImpl<AccountingYearDao, AccountingYearEntity, Long, AccountingYearDTO>
        implements AccountingYearService {

    @Override
    public AccountingYearEntity toEntity(AccountingYearDTO dto) {
        return AccountingMapperUtils.toAccountingYearEntity(dto);
    }

    @Override
    public AccountingYearDTO toDTO(AccountingYearEntity entity) {
        return AccountingMapperUtils.toAccountingYearDTO(entity);
    }

    @Override
    public AccountingYearDTO instanceDTO() {
        return AccountingYearDTO.builder().build();
    }
}
