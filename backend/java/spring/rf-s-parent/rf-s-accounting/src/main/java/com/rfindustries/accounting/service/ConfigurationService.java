package com.rfindustries.accounting.service;

import com.rfindustries.accounting.constants.AccountingConstants;
import com.rfindustries.accounting.dao.ConfigurationDao;
import com.rfindustries.accounting.dto.ConfigurationDTO;
import com.rfindustries.accounting.entities.ConfigurationEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudService;

public interface ConfigurationService extends BaseCrudService<ConfigurationDao, ConfigurationEntity, Long, ConfigurationDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + AccountingConstants.ROUTE + "/configurations";

    ConfigurationDTO findByEnterpriseIdCached(BaseCommonsParameters baseCommonsParameters);
}
