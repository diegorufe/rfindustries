package com.rfindustries.core.controllers;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.ResponseRequest;
import com.rfindustries.core.service.BaseCrudService;

public interface BaseCrudController<
        SERVICE extends BaseCrudService<DAO, ENTITY, PK, DTO>,
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO
        >
        extends BaseController {

    SERVICE getService();

    ResponseRequest<DTO> insert(BodyRequest<DTO> bodyRequest);
}
