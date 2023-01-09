package com.rfindustries.core.service;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BaseCrudService<DAO extends BaseDao<ENTITY, PK>, ENTITY extends BaseEntity<PK>, PK, DTO extends BaseDTO> extends BaseService {

    DAO getDao();

    ResponseMethod<Flux<DTO>> insertAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos);

    ResponseMethod<Mono<DTO>> insert(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ResponseMethod<Flux<DTO>> updateAll(BaseCommonsParameters baseCommonsParameters, List<DTO> dtos);

    ResponseMethod<Mono<DTO>> update(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ENTITY toEntity(BaseCommonsParameters baseCommonsParameters, DTO dto);

    DTO toDTO(BaseCommonsParameters baseCommonsParameters, ENTITY entity);

    DTO instanceDTO();

    default ResponseMethod<DTO> actionDoAfterInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    default ResponseMethod<DTO> actionDoBeforeInsertUpdate(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    ResponseMethod<Mono<Boolean>> delete(BaseCommonsParameters baseCommonsParameters, DTO dto);


    default ResponseMethod<DTO> actionDoBeforeDelete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    default ResponseMethod<DTO> actionDoAfterDelete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        return ResponseMethod.<DTO>builder().data(dto).build();
    }

    Mono<DTO> findById(BaseCommonsParameters baseCommonsParameters, PK pk);

    default <HEADER_PK> Flux<DTO> findByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return Flux.empty();
    }

    ResponseMethod<Mono<DTO>> goRead(BaseCommonsParameters baseCommonsParameters, PK pk);

    ResponseMethod<Mono<DTO>> goEdit(BaseCommonsParameters baseCommonsParameters, PK pk);

    ResponseMethod<Mono<DTO>> goAdd(BaseCommonsParameters baseCommonsParameters);

    default <HEADER_PK> Mono<Long> deleteByHeaderPk(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        return Mono.just(0L);
    }

    default PK resolvePK(DTO dto) {
        return null;
    }
}
