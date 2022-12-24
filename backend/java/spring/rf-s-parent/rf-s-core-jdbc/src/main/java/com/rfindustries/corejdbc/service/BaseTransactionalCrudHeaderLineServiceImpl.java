package com.rfindustries.corejdbc.service;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudHeaderLineService;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.core.service.impl.BaseCrudHeaderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTransactionalCrudHeaderLineServiceImpl<
        HEADER_SERVICE extends BaseCrudService<HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO>, HEADER_DAO extends BaseDao<HEADER_ENTITY, HEADER_PK>, HEADER_ENTITY extends BaseEntity<HEADER_PK>, HEADER_PK, HEADER_DTO extends BaseDTO,
        LINE_SERVICE extends BaseCrudService<LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO>, LINE_DAO extends BaseDao<LINE_ENTITY, LINE_PK>, LINE_ENTITY extends BaseEntity<LINE_PK>, LINE_PK, LINE_DTO extends BaseDTO,
        OPTION extends BaseOptionHeaderLineDTO
        >
        extends BaseCrudHeaderLineServiceImpl<
        HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO,
        LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO,
        OPTION
        >
        implements BaseCrudHeaderLineService<
        HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO,
        LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO,
        OPTION
        > {

    @Autowired
    private HEADER_SERVICE headerService;

    @Autowired
    private LINE_SERVICE lineService;


    @Override
    public HEADER_SERVICE getHeaderService() {
        return headerService;
    }

    @Override
    public LINE_SERVICE getLineService() {
        return lineService;
    }
}
