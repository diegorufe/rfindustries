package com.rfindustries.core.service;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.List;

public interface BaseCrudService<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> extends BaseService {

    DAO getDao();

    ResponseMethod<List<DTO>> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos);

    ResponseMethod<DTO> insert(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ResponseMethod<List<DTO>> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos);

    ResponseMethod<DTO> update(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ENTITY toEntity(BaseCommonsParameters baseCommonsParameters, DTO dto);

    DTO toDTO(BaseCommonsParameters baseCommonsParameters, ENTITY entity);

    DTO instanceDTO();

    default ResponseMethod<DTO> actionDoAfterInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    default ResponseMethod<DTO> actionDoBeforeInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    ResponseMethod<Boolean> delete(BaseCommonsParameters baseCommonsParameters, DTO dto);


    default  ResponseMethod<DTO> actionDoBeforeDelete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    default ResponseMethod<DTO> actionDoAfterDelete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    DTO findById(BaseCommonsParameters baseCommonsParameters, PK pk);

    default <HEADER_PK> List<DTO> findByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return List.of();
    }

    ResponseMethod<DTO> goRead(BaseCommonsParameters baseCommonsParameters, PK pk);

    ResponseMethod<DTO> goEdit(BaseCommonsParameters baseCommonsParameters, PK pk);

    ResponseMethod<DTO> goAdd(BaseCommonsParameters baseCommonsParameters);

    default <HEADER_PK> long deleteByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return 0;
    }

    default PK resolvePK(DTO dto) {
        return null;
    }
}
