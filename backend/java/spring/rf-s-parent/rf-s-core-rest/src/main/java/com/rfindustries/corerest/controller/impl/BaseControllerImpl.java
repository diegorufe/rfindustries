package com.rfindustries.corerest.controller.impl;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
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

    @Override
    public <DATA> BodyResponseRequest<DATA> resolveResponseMethod(BaseCommonsParameters baseCommonsParameters, ResponseMethod<DATA> responseMethod) {
        return BodyResponseRequest.<DATA>builder().data(responseMethod.getData()).messages(responseMethod.getMessages()).build();
    }
}
