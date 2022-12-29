package com.rfindustries.corerest.controller;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudService;
import org.springframework.http.ResponseEntity;

public interface BaseRestCrudController<
        SERVICE extends BaseCrudService<DAO, ENTITY, PK, DTO>,
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO
        >
        extends BaseCrudController<SERVICE, DAO, ENTITY, PK, DTO> {


    ResponseEntity<BodyResponseRequest<DTO>> insert(BodyRequest<DTO> bodyRequest);

    ResponseEntity<BodyResponseRequest<DTO>> update(BodyRequest<DTO> bodyRequest);

    ResponseEntity<BodyResponseRequest<Boolean>> delete(BodyRequest<DTO> bodyRequest);
}
