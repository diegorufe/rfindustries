package com.rfindustries.accounting.service;

import com.rfindustries.accounting.constants.AccountingConstants;
import com.rfindustries.accounting.constants.SerieType;
import com.rfindustries.accounting.dao.SerieDao;
import com.rfindustries.accounting.dto.SerieDTO;
import com.rfindustries.accounting.entities.SerieEntity;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudService;

public interface SerieService extends BaseCrudService<SerieDao, SerieEntity, Long, SerieDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + AccountingConstants.ROUTE + "/series";

    int incrementNumber(BaseCommonsParameters baseCommonsParameters, SerieType serieType, String code, Integer number);

    int decrementNumber(BaseCommonsParameters baseCommonsParameters, SerieType serieType, String code, Integer number);
}
