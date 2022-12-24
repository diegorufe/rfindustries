package com.rfindustries.core.service.impl;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudHeaderLineService;
import com.rfindustries.core.service.BaseCrudService;

public abstract class BaseCrudHeaderLineServiceImpl<
        HEADER_SERVICE extends BaseCrudService<HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO>, HEADER_DAO extends BaseDao<HEADER_ENTITY, HEADER_PK>, HEADER_ENTITY extends BaseEntity<HEADER_PK>, HEADER_PK, HEADER_DTO extends BaseDTO,
        LINE_SERVICE extends BaseCrudService<LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO>, LINE_DAO extends BaseDao<LINE_ENTITY, LINE_PK>, LINE_ENTITY extends BaseEntity<LINE_PK>, LINE_PK, LINE_DTO extends BaseDTO,
        OPTION extends BaseOptionHeaderLineDTO
        >
        implements BaseCrudHeaderLineService<
        HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO,
        LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO,
        OPTION
        > {
}
