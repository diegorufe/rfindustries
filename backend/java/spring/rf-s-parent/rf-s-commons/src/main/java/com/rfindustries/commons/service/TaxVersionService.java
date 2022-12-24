package com.rfindustries.commons.service;

import com.rfindustries.commons.constants.CommonsConstants;
import com.rfindustries.commons.dao.TaxVersionDao;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;

public interface TaxVersionService extends BaseCrudService<TaxVersionDao, TaxVersionEntity, Long, TaxVersionDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + CommonsConstants.ROUTE + "/tax-versions";
}
