package com.rfindustries.core.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudService;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCrudServiceImpl<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> implements BaseCrudService<DAO, ENTITY, PK, DTO> {


    @Override
    public ResponseMethod<List<DTO>> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        List<DTO> result = new ArrayList<>();
        final ResponseMethod<List<DTO>> response = ResponseMethod.<List<DTO>>builder().data(result).build();

        if (CollectionUtils.isNotEmpty(dtos)) {
            List<ENTITY> entities = dtos.stream().map(dto -> {
                        ResponseMethod<DTO> responseInsert = this.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, true);
                        this.mergeMessagesResponseMethod(response, responseInsert);
                        return this.toEntity(baseCommonsParameters, responseInsert.getData());
                    }

            ).toList();

            if (CollectionUtils.isNotEmpty(entities)) {
                result = this.getDao().insertAll(baseCommonsParameters, entities).stream().map(entity -> {
                            ResponseMethod<DTO> responseInsert = this.actionDoAfterInsertUpdate(baseCommonsParameters, this.toDTO(baseCommonsParameters, entity), true);
                            this.mergeMessagesResponseMethod(response, responseInsert);
                            return responseInsert.getData();
                        }
                ).toList();
            }
        }

        response.setData(result);
        return ResponseMethod.<List<DTO>>builder().data(result).build();
    }

    @Override
    public ResponseMethod<DTO> insert(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<List<DTO>> responseMethod = this.insertAll(baseCommonsParameters, List.of(dto));
        return ResponseMethod.<DTO>builder().data(responseMethod.getData().get(0)).messages(responseMethod.getMessages()).build();
    }

    @Override
    public ResponseMethod<DTO> update(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<List<DTO>> responseMethod = this.updateAll(baseCommonsParameters, List.of(dto));
        return ResponseMethod.<DTO>builder().data(responseMethod.getData().get(0)).messages(responseMethod.getMessages()).build();
    }

    @Override
    public ResponseMethod<List<DTO>> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        List<DTO> result = new ArrayList<>();
        final ResponseMethod<List<DTO>> response = ResponseMethod.<List<DTO>>builder().data(result).build();

        if (CollectionUtils.isNotEmpty(dtos)) {
            List<ENTITY> entities = dtos.stream().map(dto -> {
                        ResponseMethod<DTO> responseInsert = this.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, false);
                        this.mergeMessagesResponseMethod(response, responseInsert);
                        return this.toEntity(baseCommonsParameters, responseInsert.getData());
                    }

            ).toList();

            if (CollectionUtils.isNotEmpty(entities)) {
                result = this.getDao().updateAll(baseCommonsParameters, entities).stream().map(entity -> {
                            ResponseMethod<DTO> responseInsert = this.actionDoAfterInsertUpdate(baseCommonsParameters, this.toDTO(baseCommonsParameters, entity), false);
                            this.mergeMessagesResponseMethod(response, responseInsert);
                            return responseInsert.getData();
                        }
                ).toList();
            }
        }

        response.setData(result);
        return response;
    }

    @Override
    public ResponseMethod<Boolean> delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<DTO> responseMethod = this.actionDoBeforeDelete(baseCommonsParameters, dto);
        this.getDao().delete(this.toEntity(baseCommonsParameters, responseMethod.getData()));
        this.actionDoAfterDelete(baseCommonsParameters, responseMethod.getData());
        return ResponseMethod.<Boolean>builder().data(true).build();
    }

    @Override
    public DTO findById(BaseCommonsParameters baseCommonsParameters, PK pk) {
        return this.toDTO(baseCommonsParameters, this.getDao().findById(pk).orElseThrow());
    }

    @Override
    public ResponseMethod<DTO> goRead(BaseCommonsParameters baseCommonsParameters, PK pk) {
        return ResponseMethod.<DTO>builder().data(this.findById(baseCommonsParameters, pk)).build();
    }

    @Override
    public ResponseMethod<DTO> goAdd(BaseCommonsParameters baseCommonsParameters) {
        return ResponseMethod.<DTO>builder().data(this.instanceDTO()).build();
    }

    @Override
    public ResponseMethod<DTO> goEdit(BaseCommonsParameters baseCommonsParameters, PK pk) {
        return ResponseMethod.<DTO>builder().data(this.findById(baseCommonsParameters, pk)).build();
    }
}
