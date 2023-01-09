package com.rfindustries.core.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.core.utils.ReactorUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public abstract class BaseCrudServiceImpl<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> implements BaseCrudService<DAO, ENTITY, PK, DTO> {


    @Override
    public ResponseMethod<Flux<DTO>> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        Flux<DTO> result = null;
        final ResponseMethod<Flux<DTO>> response = ResponseMethod.<Flux<DTO>>builder().data(result).build();

        if (CollectionUtils.isNotEmpty(dtos)) {
            List<ENTITY> entities = dtos.stream().map(dto -> {
                        ResponseMethod<DTO> responseInsert = this.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, true);
                        this.mergeMessagesResponseMethod(response, responseInsert);
                        return this.toEntity(baseCommonsParameters, responseInsert.getData());
                    }

            ).toList();

            if (CollectionUtils.isNotEmpty(entities)) {
                result = this.getDao().insertAllEntities(baseCommonsParameters, entities).map(entity -> {
                            ResponseMethod<DTO> responseInsert = this.actionDoAfterInsertUpdate(baseCommonsParameters, this.toDTO(baseCommonsParameters, entity), true);
                            this.mergeMessagesResponseMethod(response, responseInsert);
                            return responseInsert.getData();
                        }
                );
            }
        }

        response.setData(result);
        return response;
    }

    @Override
    public ResponseMethod<Mono<DTO>> insert(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<Flux<DTO>> responseMethod = this.insertAll(baseCommonsParameters, List.of(dto));
        return ResponseMethod.<Mono<DTO>>builder().data(ReactorUtils.fluxToMono(responseMethod.getData())).messages(responseMethod.getMessages()).build();
    }

    @Override
    public ResponseMethod<Mono<DTO>> update(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<Flux<DTO>> responseMethod = this.updateAll(baseCommonsParameters, List.of(dto));
        return ResponseMethod.<Mono<DTO>>builder().data(ReactorUtils.fluxToMono(responseMethod.getData())).messages(responseMethod.getMessages()).build();
    }

    @Override
    public ResponseMethod<Flux<DTO>> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos) {
        Flux<DTO> result = null;
        final ResponseMethod<Flux<DTO>> response = ResponseMethod.<Flux<DTO>>builder().data(result).build();

        if (CollectionUtils.isNotEmpty(dtos)) {
            List<ENTITY> entities = dtos.stream().map(dto -> {
                        ResponseMethod<DTO> responseInsert = this.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, false);
                        this.mergeMessagesResponseMethod(response, responseInsert);
                        return this.toEntity(baseCommonsParameters, responseInsert.getData());
                    }

            ).toList();

            if (CollectionUtils.isNotEmpty(entities)) {
                result = this.getDao().updateAllEntities(baseCommonsParameters, entities).map(entity -> {
                            ResponseMethod<DTO> responseInsert = this.actionDoAfterInsertUpdate(baseCommonsParameters, this.toDTO(baseCommonsParameters, entity), false);
                            this.mergeMessagesResponseMethod(response, responseInsert);
                            return responseInsert.getData();
                        }
                );
            }
        }

        response.setData(result);
        return response;
    }

    @Override
    public ResponseMethod<Mono<Boolean>> delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<DTO> responseMethod = this.actionDoBeforeDelete(baseCommonsParameters, dto);
        this.getDao().deleteEntity(this.toEntity(baseCommonsParameters, responseMethod.getData()));
        this.actionDoAfterDelete(baseCommonsParameters, responseMethod.getData());
        return ResponseMethod.<Mono<Boolean>>builder().data(Mono.just(true)).build();
    }

    @Override
    public Mono<DTO> findById(BaseCommonsParameters baseCommonsParameters, PK pk) {
        return Mono.just(this.toDTO(baseCommonsParameters, this.getDao().findEntityById(pk).blockOptional().orElseThrow()));
    }

    @Override
    public ResponseMethod<Mono<DTO>> goRead(BaseCommonsParameters baseCommonsParameters, PK pk) {
        return ResponseMethod.<Mono<DTO>>builder().data(this.findById(baseCommonsParameters, pk)).build();
    }

    @Override
    public ResponseMethod<Mono<DTO>> goAdd(BaseCommonsParameters baseCommonsParameters) {
        return ResponseMethod.<Mono<DTO>>builder().data(Mono.just(this.instanceDTO())).build();
    }

    @Override
    public ResponseMethod<Mono<DTO>> goEdit(BaseCommonsParameters baseCommonsParameters, PK pk) {
        return ResponseMethod.<Mono<DTO>>builder().data(this.findById(baseCommonsParameters, pk)).build();
    }
}
