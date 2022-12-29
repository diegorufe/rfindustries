package com.rfindustries.corerest.controller.impl;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.corerest.controller.BaseRestCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseRestCrudControllerImpl<
        SERVICE extends BaseCrudService<DAO, ENTITY, PK, DTO>,
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO
        >
        extends BaseControllerImpl
        implements BaseRestCrudController<SERVICE, DAO, ENTITY, PK, DTO> {

    @Autowired
    private SERVICE service;

    @Override
    public SERVICE getService() {
        return service;
    }

    @PostMapping(RouteConstants.INSERT)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> insert(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.insert(this.resolveCommonsParameters(), bodyRequest.getData())));
    }

    @PutMapping(RouteConstants.UPDATE)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> update(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.update(this.resolveCommonsParameters(), bodyRequest.getData())));
    }

    @DeleteMapping(RouteConstants.DELETE)
    @Override
    public ResponseEntity<BodyResponseRequest<Boolean>> delete(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.delete(this.resolveCommonsParameters(), bodyRequest.getData())));
    }

    @GetMapping(RouteConstants.GO_READ)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> goRead(@RequestParam(BaseCrudController.REQUEST_PARAM_PK) PK pk) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.goRead(this.resolveCommonsParameters(), pk)));
    }

    @GetMapping(RouteConstants.GO_EDIT)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> goEdit(@RequestParam(BaseCrudController.REQUEST_PARAM_PK) PK pk) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.goEdit(this.resolveCommonsParameters(), pk)));
    }

    @GetMapping(RouteConstants.GO_ADD)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> goAdd() {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.goAdd(this.resolveCommonsParameters())));
    }
}
