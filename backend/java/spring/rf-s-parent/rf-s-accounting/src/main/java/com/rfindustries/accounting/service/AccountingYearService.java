package com.rfindustries.accounting.service;

import com.rfindustries.accounting.constants.AccountingConstants;
import com.rfindustries.accounting.dao.AccountingYearDao;
import com.rfindustries.accounting.dto.AccountingYearDTO;
import com.rfindustries.accounting.entities.AccountingYearEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;

public interface AccountingYearService extends BaseCrudService<AccountingYearDao, AccountingYearEntity, Long, AccountingYearDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + AccountingConstants.ROUTE + "/accounting-years";


}
