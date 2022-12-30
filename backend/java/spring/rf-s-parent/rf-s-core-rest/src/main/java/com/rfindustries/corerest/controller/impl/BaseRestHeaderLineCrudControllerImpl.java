package com.rfindustries.corerest.controller.impl;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.constansts.rest.RouteConstants;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.dto.BaseHeaderLineDTO;
import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudHeaderLineService;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.corerest.controller.BaseRestHeaderLineCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseRestHeaderLineCrudControllerImpl<
        SERVICE extends BaseCrudHeaderLineService<DTO, HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO, LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO, OPTION>,
        DTO extends BaseHeaderLineDTO<HEADER_DTO, LINE_DTO, OPTION>,
        HEADER_SERVICE extends BaseCrudService<HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO>,
        HEADER_DAO extends BaseDao<HEADER_ENTITY, HEADER_PK>,
        HEADER_ENTITY extends BaseEntity<HEADER_PK>,
        HEADER_PK,
        HEADER_DTO extends BaseDTO,
        LINE_SERVICE extends BaseCrudService<LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO>,
        LINE_DAO extends BaseDao<LINE_ENTITY, LINE_PK>,
        LINE_ENTITY extends BaseEntity<LINE_PK>,
        LINE_PK,
        LINE_DTO extends BaseDTO,
        OPTION extends BaseOptionHeaderLineDTO
        >
        extends BaseControllerImpl
        implements BaseRestHeaderLineCrudController<SERVICE, DTO, HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO, LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO, OPTION> {

    @Autowired
    private SERVICE service;

    @Override
    public SERVICE getService() {
        return service;
    }

    @PostMapping(RouteConstants.INSERT)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> insert(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.upsert(this.resolveCommonsParameters(), bodyRequest.getData(), true)));
    }

    @PutMapping(RouteConstants.UPDATE)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> update(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.upsert(this.resolveCommonsParameters(), bodyRequest.getData(), false)));
    }

    @DeleteMapping(RouteConstants.DELETE)
    @Override
    public ResponseEntity<BodyResponseRequest<Boolean>> delete(@RequestBody BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.delete(this.resolveCommonsParameters(), bodyRequest.getData())));
    }

    @GetMapping(RouteConstants.GO_READ)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> goRead(@RequestParam(BaseCrudController.REQUEST_PARAM_PK) HEADER_PK pk) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.goRead(this.resolveCommonsParameters(), pk)));
    }

    @GetMapping(RouteConstants.GO_EDIT)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> goEdit(@RequestParam(BaseCrudController.REQUEST_PARAM_PK) HEADER_PK pk) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.goEdit(this.resolveCommonsParameters(), pk)));
    }

    @GetMapping(RouteConstants.GO_ADD)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> goAdd() {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.goAdd(this.resolveCommonsParameters())));
    }

    @GetMapping(RouteConstants.CALCULATE)
    @Override
    public ResponseEntity<BodyResponseRequest<DTO>> calculate(BodyRequest<DTO> bodyRequest) {
        return ResponseEntity.ok(new BodyResponseRequest<>(this.service.calculate(this.resolveCommonsParameters(), bodyRequest.getData())));
    }
}
