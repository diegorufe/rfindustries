package com.rfindustries.accounting.service;

import com.rfindustries.accounting.constants.AccountingConstants;
import com.rfindustries.accounting.dao.TaxDao;
import com.rfindustries.accounting.dto.TaxDTO;
import com.rfindustries.accounting.entities.TaxEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;

public interface TaxService extends BaseCrudService<TaxDao, TaxEntity, Long, TaxDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + AccountingConstants.ROUTE + "/taxes";
}
