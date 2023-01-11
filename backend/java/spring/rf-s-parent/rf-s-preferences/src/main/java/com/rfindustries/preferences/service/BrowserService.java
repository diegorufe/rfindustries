package com.rfindustries.preferences.service;

import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.preferences.constants.PreferenceConstants;
import com.rfindustries.preferences.dao.BrowserDao;
import com.rfindustries.preferences.dto.BrowserDTO;
import com.rfindustries.preferences.entities.BrowserEntity;

public interface BrowserService extends BaseCrudService<BrowserDao, BrowserEntity, String, BrowserDTO> {
    String ROUTE = RouteConstants.BASE_API_MODULES + PreferenceConstants.ROUTE + "/browsers";
}
