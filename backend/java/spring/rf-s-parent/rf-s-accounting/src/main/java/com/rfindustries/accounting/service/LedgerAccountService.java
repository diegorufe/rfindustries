package com.rfindustries.accounting.service;

import com.rfindustries.accounting.constants.AccountingConstants;
import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dao.LedgerAccountDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.dto.LedgerAccountDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.accounting.entities.LedgerAccountEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;

public interface LedgerAccountService extends BaseCrudService<LedgerAccountDao, LedgerAccountEntity, Long, LedgerAccountDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + AccountingConstants.ROUTE + "/ledger-accounts";
}
