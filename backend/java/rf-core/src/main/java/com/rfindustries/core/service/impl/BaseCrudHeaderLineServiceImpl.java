package com.rfindustries.core.service.impl;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.dto.BaseHeaderLineDTO;
import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.service.BaseCrudHeaderLineService;
import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.core.utils.ReactorUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCrudHeaderLineServiceImpl<
        DTO extends BaseHeaderLineDTO<HEADER_DTO, LINE_DTO, OPTION>,
        HEADER_SERVICE extends BaseCrudService<HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO>, HEADER_DAO extends BaseDao<HEADER_ENTITY, HEADER_PK>, HEADER_ENTITY extends BaseEntity<HEADER_PK>, HEADER_PK, HEADER_DTO extends BaseDTO,
        LINE_SERVICE extends BaseCrudService<LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO>, LINE_DAO extends BaseDao<LINE_ENTITY, LINE_PK>, LINE_ENTITY extends BaseEntity<LINE_PK>, LINE_PK, LINE_DTO extends BaseDTO,
        OPTION extends BaseOptionHeaderLineDTO
        >
        implements BaseCrudHeaderLineService<
        DTO,
        HEADER_SERVICE, HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO,
        LINE_SERVICE, LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO,
        OPTION
        > {


    @Override
    public ResponseMethod<Mono<DTO>> goAdd(BaseCommonsParameters baseCommonsParameters) {
        ResponseMethod<Mono<DTO>> responseMethod = ResponseMethod.<Mono<DTO>>builder().build();
        DTO dto = this.instanceDTO();
        ResponseMethod<Mono<HEADER_DTO>> responseHeader = this.getHeaderService().goAdd(baseCommonsParameters);

        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        dto.setHeader(responseHeader.getData().block());
        dto.setLines(new ArrayList<>());

        responseMethod.setData(Mono.just(dto));
        return responseMethod;
    }

    @Override
    public ResponseMethod<Mono<DTO>> goRead(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        ResponseMethod<Mono<DTO>> responseMethod = ResponseMethod.<Mono<DTO>>builder().build();
        ResponseMethod<Mono<HEADER_DTO>>  responseHeader = this.getHeaderService().goRead(baseCommonsParameters, headerPk);
        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        DTO dto = this.instanceDTO();
        dto.setHeader(responseHeader.getData().block());
        responseMethod.setData(Mono.just(dto));
        return responseMethod;
    }

    @Override
    public ResponseMethod<Mono<DTO>> goEdit(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        ResponseMethod<Mono<DTO>> responseMethod = ResponseMethod.<Mono<DTO>>builder().build();
        ResponseMethod<Mono<HEADER_DTO>>  responseHeader = this.getHeaderService().goEdit(baseCommonsParameters, headerPk);
        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        Flux<LINE_DTO> lines = this.getLineService().findByHeaderPk(baseCommonsParameters, headerPk);

        DTO dto = this.instanceDTO();

        dto.setHeader(responseHeader.getData().block());
        dto.setLines(ReactorUtils.fluxToMonoList(lines).block());

        return responseMethod;
    }

    @Override
    public ResponseMethod<Mono<Boolean>> delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        // TODO check validations
        this.getLineService().deleteByHeaderPk(baseCommonsParameters, this.getHeaderService().resolvePK(dto.getHeader()));
        return this.getHeaderService().delete(baseCommonsParameters, dto.getHeader());
    }

    @Override
    public ResponseMethod<Mono<DTO>> addLine(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<Mono<DTO>> responseMethod = ResponseMethod.<Mono<DTO>>builder().build();
        if (dto.getLines() == null) {
            dto.setLines(new ArrayList<>());
        }
        dto.getLines().add(this.getLineService().instanceDTO());
        responseMethod.setData(Mono.just(dto));
        return responseMethod;
    }
}
