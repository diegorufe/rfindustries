package com.rfindustries.corejdbc.service;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.core.service.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseTransactionalCrudServiceImpl<
        DAO extends BaseDao<ENTITY, PK>,
        ENTITY extends BaseEntity<PK>,
        PK,
        DTO extends BaseDTO>
        extends BaseCrudServiceImpl<DAO, ENTITY, PK, DTO>
    implements BaseCrudService<DAO, ENTITY, PK, DTO>
{

    @Autowired
    private DAO dao;

    @Override
    public DAO getDao() {
        return this.dao;
    }


    @Transactional
    @Override
    public List<DTO> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        return super.insertAll(baseCommonsParameters, dtos);
    }

    @Transactional
    @Override
    public DTO insert(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return super.insert(baseCommonsParameters, dto);
    }

    @Transactional
    @Override
    public DTO update(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return super.update(baseCommonsParameters, dto);
    }

    @Transactional
    @Override
    public List<DTO> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        return super.updateAll(baseCommonsParameters, dtos);
    }

    @Transactional
    @Override
    public void delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        super.delete(baseCommonsParameters, dto);
    }
}
