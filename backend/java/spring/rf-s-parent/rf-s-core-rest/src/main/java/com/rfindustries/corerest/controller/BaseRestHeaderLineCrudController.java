package com.rfindustries.corerest.controller;

import com.rfindustries.core.beans.rest.BodyRequest;
import com.rfindustries.core.beans.rest.BodyResponseRequest;
import com.rfindustries.core.controllers.BaseHeaderLineCrudController;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.dto.BaseHeaderLineDTO;
import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudHeaderLineService;
import com.rfindustries.core.service.BaseCrudService;
import org.springframework.http.ResponseEntity;

public interface BaseRestHeaderLineCrudController<
        SERVICE extends BaseCrudHeaderLineService<DTO, HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO, LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO, OPTION>,
        DTO extends BaseHeaderLineDTO<HEADER_DTO, LINE_DTO, OPTION>,
        HEADER_SERVICE extends BaseCrudService<HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO>, HEADER_DAO extends BaseDao<HEADER_ENTITY, HEADER_PK>, HEADER_ENTITY extends BaseEntity<HEADER_PK>, HEADER_PK, HEADER_DTO extends BaseDTO,
        LINE_SERVICE extends BaseCrudService<LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO>, LINE_DAO extends BaseDao<LINE_ENTITY, LINE_PK>, LINE_ENTITY extends BaseEntity<LINE_PK>, LINE_PK, LINE_DTO extends BaseDTO,
        OPTION extends BaseOptionHeaderLineDTO
        >
        extends BaseHeaderLineCrudController<SERVICE, DTO, HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO, LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO, OPTION> {


    ResponseEntity<BodyResponseRequest<DTO>> insert(BodyRequest<DTO> bodyRequest);

    ResponseEntity<BodyResponseRequest<DTO>> update(BodyRequest<DTO> bodyRequest);

    ResponseEntity<BodyResponseRequest<Boolean>> delete(BodyRequest<DTO> bodyRequest);

    ResponseEntity<BodyResponseRequest<DTO>> goRead(HEADER_PK pk);

    ResponseEntity<BodyResponseRequest<DTO>> goEdit(HEADER_PK pk);

    ResponseEntity<BodyResponseRequest<DTO>> goAdd();

    ResponseEntity<BodyResponseRequest<DTO>> calculate(BodyRequest<DTO> bodyRequest);
}
