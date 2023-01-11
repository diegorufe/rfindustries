package com.rfindustries.coremongo.service;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.core.service.impl.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseReactiveCrudServiceImpl<
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO>
        extends BaseCrudServiceImpl<DAO, ENTITY, PK, DTO>
        implements BaseCrudService<DAO, ENTITY, PK, DTO> {

    @Autowired
    private DAO dao;

    @Override
    public DAO getDao() {
        return this.dao;
    }
}
