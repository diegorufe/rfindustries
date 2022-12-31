package com.rfindustries.core.controllers;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.features.BaseCommonsParameters;

public interface BaseController {
    BaseCommonsParameters resolveCommonsParameters();

    <DATA> BodyResponseRequest<DATA> resolveResponseMethod(BaseCommonsParameters baseCommonsParameters, ResponseMethod<DATA> responseMethod);
}
