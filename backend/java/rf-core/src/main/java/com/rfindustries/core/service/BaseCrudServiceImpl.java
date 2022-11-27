package com.rfindustries.core.service;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCrudServiceImpl<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> implements BaseCrudService<DAO, ENTITY, PK, DTO> {


    @Override
    public List<DTO> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        List<DTO> result = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(dtos)) {
            List<ENTITY> entities = dtos.stream().map(dto ->
                    this.toEntity(this.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, true))
            ).toList();

            if (CollectionUtils.isNotEmpty(entities)) {
                result = this.getDao().insertAll(baseCommonsParameters, entities).stream().map(entity -> this.actionDoAfterInsertUpdate(baseCommonsParameters, this.toDTO(entity), true)).toList();
            }
        }

        return result;
    }

    @Override
    public DTO insert(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return this.insertAll(baseCommonsParameters, List.of(dto)).get(0);
    }

    @Override
    public DTO update(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return this.updateAll(baseCommonsParameters, List.of(dto)).get(0);
    }

    @Override
    public List<DTO> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        List<DTO> result = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(dtos)) {
            List<ENTITY> entities = dtos.stream().map(dto ->
                    this.toEntity(this.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, false))
            ).collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(entities)) {
                result = this.getDao().updateAll(baseCommonsParameters, entities).stream().map(entity -> this.actionDoAfterInsertUpdate(baseCommonsParameters, this.toDTO(entity), false)).collect(Collectors.toList());
            }
        }

        return result;
    }

    @Override
    public boolean delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        dto = this.actionDoBeforeDelete(baseCommonsParameters, dto);
        this.getDao().delete(this.toEntity(dto));
        this.actionDoAfterDelete(baseCommonsParameters, dto);
        return true;
    }
}
