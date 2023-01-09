package com.rfindustries.core.controllers;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.features.BaseCommonsParameters;
import reactor.core.publisher.Mono;

public interface BaseController {
    BaseCommonsParameters resolveCommonsParameters();

    <DATA> BodyResponseRequest<DATA> resolveResponseMethod(BaseCommonsParameters baseCommonsParameters, ResponseMethod<DATA> responseMethod);

    <DATA> BodyResponseRequest<DATA> resolveMonoResponseMethod(BaseCommonsParameters baseCommonsParameters, ResponseMethod<Mono<DATA>> responseMethod);


}
