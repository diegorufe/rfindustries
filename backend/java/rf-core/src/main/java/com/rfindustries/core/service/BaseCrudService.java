package com.rfindustries.core.service;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;

public interface BaseCrudService<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> extends BaseService {
}
