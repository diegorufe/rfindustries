package com.rfindustries.accounting.service;

import com.rfindustries.accounting.constants.AccountingConstants;
import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;

public interface AccountingService extends BaseCrudService<AccountingDao, AccountingEntity, Long, AccountingDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + AccountingConstants.ROUTE + "/accounting";
}
