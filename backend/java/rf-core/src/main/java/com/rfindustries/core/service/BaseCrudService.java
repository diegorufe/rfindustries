package com.rfindustries.core.service;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.List;

public interface BaseCrudService<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> extends BaseService {

    DAO getDao();

    List<DTO> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos);

    DTO insert(BaseCommonsParameters baseCommonsParameters, DTO dto);

    List<DTO> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos);

    DTO update(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ENTITY toEntity(DTO dto);

    DTO toDTO(ENTITY entity);

    default DTO actionDoAfterInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean create){
        return dto;
    }

    default DTO actionDoBeforeInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean create){
        return dto;
    }

    boolean delete(BaseCommonsParameters baseCommonsParameters, DTO dto);


    default DTO actionDoBeforeDelete(BaseCommonsParameters baseCommonsParameters, DTO dto){
        return dto;
    }

    default void actionDoAfterDelete(BaseCommonsParameters baseCommonsParameters, DTO dto){
    }
}
