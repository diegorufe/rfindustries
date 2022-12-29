package com.rfindustries.corerest.controller.impl;

import com.rfindustries.core.controllers.BaseController;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.features.BaseCommonsParametersImpl;

public abstract class BaseControllerImpl implements BaseController {

    @Override
    public BaseCommonsParameters resolveCommonsParameters() {
        // TODO get for security context
        return BaseCommonsParametersImpl.builder()
                .businessCustomerId(1L)
                .enterpriseId(1L)
                .build();
    }
}
