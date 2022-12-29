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

    ENTITY toEntity(BaseCommonsParameters baseCommonsParameters, DTO dto);

    DTO toDTO(BaseCommonsParameters baseCommonsParameters, ENTITY entity);

    DTO instanceDTO();

    default DTO actionDoAfterInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert) {
        return dto;
    }

    default DTO actionDoBeforeInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert) {
        return dto;
    }

    boolean delete(BaseCommonsParameters baseCommonsParameters, DTO dto);


    default DTO actionDoBeforeDelete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return dto;
    }

    default void actionDoAfterDelete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
    }

    DTO findById(BaseCommonsParameters baseCommonsParameters, PK pk);

    default <HEADER_PK> List<DTO> findByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return List.of();
    }

    DTO goRead(BaseCommonsParameters baseCommonsParameters, PK pk);

    DTO goEdit(BaseCommonsParameters baseCommonsParameters, PK pk);

    DTO goAdd(BaseCommonsParameters baseCommonsParameters);

    default <HEADER_PK> long deleteByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return 0;
    }

    default PK resolvePK(DTO dto) {
        return null;
    }
}
