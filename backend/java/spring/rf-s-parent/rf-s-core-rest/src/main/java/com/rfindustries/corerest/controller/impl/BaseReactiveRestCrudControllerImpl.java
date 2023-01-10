package com.rfindustries.corerest.controller.impl;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.corerest.controller.BaseReactiveRestCrudController;
import com.rfindustries.corerest.controller.BaseRestCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

public abstract class BaseReactiveRestCrudControllerImpl<
        SERVICE extends BaseCrudService<DAO, ENTITY, PK, DTO>,
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO
        >
        extends BaseControllerImpl
        implements BaseReactiveRestCrudController<SERVICE, DAO, ENTITY, PK, DTO> {

    @Autowired
    private SERVICE service;

    @Override
    public SERVICE getService() {
        return service;
    }

    @PostMapping(RouteConstants.INSERT)
    @Override
    public Mono<ResponseEntity<BodyResponseRequest<DTO>>> insert(@RequestBody BodyRequest<DTO> bodyRequest) {
        BaseCommonsParameters commonsParameters = this.resolveCommonsParameters();
        return Mono.just(ResponseEntity.ok(this.resolveMonoResponseMethod(commonsParameters, this.service.insert(commonsParameters, bodyRequest.getData()))));
    }

    @PutMapping(RouteConstants.UPDATE)
    @Override
    public Mono<ResponseEntity<BodyResponseRequest<DTO>>> update(@RequestBody BodyRequest<DTO> bodyRequest) {
        BaseCommonsParameters commonsParameters = this.resolveCommonsParameters();
        return Mono.just(ResponseEntity.ok(this.resolveMonoResponseMethod(commonsParameters, this.service.update(commonsParameters, bodyRequest.getData()))));
    }

    @DeleteMapping(RouteConstants.DELETE)
    @Override
    public Mono<ResponseEntity<BodyResponseRequest<Boolean>>> delete(@RequestBody BodyRequest<DTO> bodyRequest) {
        BaseCommonsParameters commonsParameters = this.resolveCommonsParameters();
        return Mono.just(ResponseEntity.ok(this.resolveMonoResponseMethod(commonsParameters, this.service.delete(commonsParameters, bodyRequest.getData()))));
    }

    @GetMapping(RouteConstants.GO_READ)
    @Override
    public Mono<ResponseEntity<BodyResponseRequest<DTO>>> goRead(@RequestParam(BaseCrudController.REQUEST_PARAM_PK) PK pk) {
        BaseCommonsParameters commonsParameters = this.resolveCommonsParameters();
        return Mono.just(ResponseEntity.ok(this.resolveMonoResponseMethod(commonsParameters, this.service.goRead(commonsParameters, pk))));
    }

    @GetMapping(RouteConstants.GO_EDIT)
    @Override
    public Mono<ResponseEntity<BodyResponseRequest<DTO>>> goEdit(@RequestParam(BaseCrudController.REQUEST_PARAM_PK) PK pk) {
        BaseCommonsParameters commonsParameters = this.resolveCommonsParameters();
        return Mono.just(ResponseEntity.ok(this.resolveMonoResponseMethod(commonsParameters, this.service.goEdit(commonsParameters, pk))));
    }

    @GetMapping(RouteConstants.GO_ADD)
    @Override
    public Mono<ResponseEntity<BodyResponseRequest<DTO>>> goAdd() {
        BaseCommonsParameters commonsParameters = this.resolveCommonsParameters();
        return Mono.just(ResponseEntity.ok(this.resolveMonoResponseMethod(commonsParameters, this.service.goAdd(commonsParameters))));
    }
}
