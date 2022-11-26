package com.rfindustries.corerest.controllers;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.ResponseRequest;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.corerest.beans.ResponseRequestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseCrudControllerImpl<
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
    @Override
    public ResponseRequest<DTO> insert(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseRequestImpl.ok(this.service.insert(this.resolveCommonsParameters(), bodyRequest.getData()));
    }
}
