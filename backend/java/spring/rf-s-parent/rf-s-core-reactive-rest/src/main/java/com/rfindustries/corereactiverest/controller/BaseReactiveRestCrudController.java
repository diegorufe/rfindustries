package com.rfindustries.corereactiverest.controller;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.controllers.BaseCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudService;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface BaseReactiveRestCrudController<
        SERVICE extends BaseCrudService<DAO, ENTITY, PK, DTO>,
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO
        >
        extends BaseCrudController<SERVICE, DAO, ENTITY, PK, DTO> {


    Mono<ResponseEntity<BodyResponseRequest<DTO>>> insert(BodyRequest<DTO> bodyRequest);

    Mono<ResponseEntity<BodyResponseRequest<DTO>>> update(BodyRequest<DTO> bodyRequest);

    Mono<ResponseEntity<BodyResponseRequest<Boolean>>> delete(BodyRequest<DTO> bodyRequest);

    Mono<ResponseEntity<BodyResponseRequest<DTO>>> goRead(PK pk);

    Mono<ResponseEntity<BodyResponseRequest<DTO>>> goEdit(PK pk);

    Mono<ResponseEntity<BodyResponseRequest<DTO>>> goAdd();
}
