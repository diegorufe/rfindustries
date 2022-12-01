package com.rfindustries.corerest.controllers;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseRestCrudControllerImpl<
        SERVICE extends BaseCrudService<DAO, ENTITY, PK, DTO>,
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO
        >
        extends BaseControllerImpl
        implements BaseCrudController<SERVICE, DAO, ENTITY, PK, DTO> {

    @Autowired
    private SERVICE service;

    @Override
    public SERVICE getService() {
        return service;
    }

    @PostMapping(RouteConstants.INSERT)
    public ResponseEntity<BodyResponseRequest<DTO>> insert(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.insert(this.resolveCommonsParameters(), bodyRequest.getData())));
    }

    @PutMapping(RouteConstants.UPDATE)
    public ResponseEntity<BodyResponseRequest<DTO>> update(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.update(this.resolveCommonsParameters(), bodyRequest.getData())));
    }

    @DeleteMapping(RouteConstants.DELETE)
    public ResponseEntity<BodyResponseRequest<Boolean>> delete(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.delete(this.resolveCommonsParameters(), bodyRequest.getData())));
    }
}
