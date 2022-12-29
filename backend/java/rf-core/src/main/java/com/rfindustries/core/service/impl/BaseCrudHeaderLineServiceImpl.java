package com.rfindustries.core.service.impl;

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
    public DTO goAdd(BaseCommonsParameters baseCommonsParameters) {
        DTO dto = this.instanceDTO();
        dto.setHeader(this.getHeaderService().goAdd(baseCommonsParameters));
        dto.setLines(new ArrayList<>());

        return dto;
    }

    @Override
    public DTO goRead(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        HEADER_DTO header = this.getHeaderService().goEdit(baseCommonsParameters, headerPk);
        DTO dto = this.instanceDTO();
        dto.setHeader(header);
        return dto;
    }

    @Override
    public DTO goEdit(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk) {
        HEADER_DTO header = this.getHeaderService().goEdit(baseCommonsParameters, headerPk);
        List<LINE_DTO> lines = this.getLineService().findByHeaderPk(baseCommonsParameters, headerPk);

        DTO dto = this.instanceDTO();

        dto.setHeader(header);
        dto.setLines(lines);

        return dto;
    }

    @Override
    public boolean delete(BaseCommonsParameters baseCommonsParameters, DTO dto) {
        // TODO check validations
        this.getLineService().findByHeaderPk(baseCommonsParameters, this.getHeaderService().resolvePK(dto.getHeader()));
        this.getHeaderService().delete(baseCommonsParameters, dto.getHeader());
        return true;
    }
}
