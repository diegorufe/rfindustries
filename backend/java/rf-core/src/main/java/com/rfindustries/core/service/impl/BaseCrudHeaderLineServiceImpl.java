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
    public ResponseMethod<DTO> goAdd(BaseCommonsParameters baseCommonsParameters) {
        ResponseMethod<DTO> responseMethod = ResponseMethod.<DTO>builder().build();
        DTO dto = this.instanceDTO();
        ResponseMethod<HEADER_DTO> responseHeader = this.getHeaderService().goAdd(baseCommonsParameters);

        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        dto.setHeader(responseHeader.getData());
        dto.setLines(new ArrayList<>());

        responseMethod.setData(dto);
        return responseMethod;
    }

    @Override
    public ResponseMethod<DTO> goRead(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        ResponseMethod<DTO> responseMethod = ResponseMethod.<DTO>builder().build();
        ResponseMethod<HEADER_DTO> responseHeader = this.getHeaderService().goEdit(baseCommonsParameters, headerPk);
        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        DTO dto = this.instanceDTO();
        dto.setHeader(responseHeader.getData());
        responseMethod.setData(dto);
        return responseMethod;
    }

    @Override
    public ResponseMethod<DTO> goEdit(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        ResponseMethod<DTO> responseMethod = ResponseMethod.<DTO>builder().build();
        ResponseMethod<HEADER_DTO> responseHeader = this.getHeaderService().goEdit(baseCommonsParameters, headerPk);
        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        List<LINE_DTO> lines = this.getLineService().findByHeaderPk(baseCommonsParameters, headerPk);

        DTO dto = this.instanceDTO();

        dto.setHeader(responseHeader.getData());
        dto.setLines(lines);

        return responseMethod;
    }

    @Override
    public ResponseMethod<Boolean> delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        // TODO check validations
        this.getLineService().deleteByHeaderPk(baseCommonsParameters, this.getHeaderService().resolvePK(dto.getHeader()));
        return this.getHeaderService().delete(baseCommonsParameters, dto.getHeader());
    }

    @Override
    public ResponseMethod<DTO> addLine(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        ResponseMethod<DTO> responseMethod = ResponseMethod.<DTO>builder().build();
        if (dto.getLines() == null) {
            dto.setLines(new ArrayList<>());
        }
        dto.getLines().add(this.getLineService().instanceDTO());
        responseMethod.setData(dto);
        return responseMethod;
    }
}
