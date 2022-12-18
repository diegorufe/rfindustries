package com.rfindustries.commons.service;

import com.rfindustries.commons.constants.CommonsConstants;
import com.rfindustries.commons.dao.TaxDao;
import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;

public interface TaxService extends BaseCrudService<TaxDao, TaxEntity, Long, TaxDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + CommonsConstants.ROUTE + "/taxes";
}
