package com.rfindustries.core.service;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.dto.BaseDTO;
import com.rfindustries.core.dto.BaseHeaderLineDTO;
import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;

public interface BaseCrudHeaderLineService<
        DTO extends BaseHeaderLineDTO<HEADER_DTO, LINE_DTO, OPTION>,
        HEADER_SERVICE extends BaseCrudService<HEADER_DAO, HEADER_ENTITY, HEADER_PK, HEADER_DTO>,
        HEADER_DAO extends BaseDao<HEADER_ENTITY, HEADER_PK>,
        HEADER_ENTITY extends BaseEntity<HEADER_PK>,
        HEADER_PK,
        HEADER_DTO extends BaseDTO,
        LINE_SERVICE extends BaseCrudService<LINE_DAO, LINE_ENTITY, LINE_PK, LINE_DTO>,
        LINE_DAO extends BaseDao<LINE_ENTITY, LINE_PK>,
        LINE_ENTITY extends BaseEntity<LINE_PK>,
        LINE_PK,
        LINE_DTO extends BaseDTO,
        OPTION extends BaseOptionHeaderLineDTO
        > {


    HEADER_SERVICE getHeaderService();

    LINE_SERVICE getLineService();

    DTO instanceDTO();

    DTO goAdd(BaseCommonsParameters baseCommonsParameters);

    DTO goRead(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk);

    DTO goEdit(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk);

    DTO upsert(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert);

    boolean delete(BaseCommonsParameters baseCommonsParameters, DTO dto);

    DTO addLine(BaseCommonsParameters baseCommonsParameters, DTO dto);

    DTO calculate(BaseCommonsParameters baseCommonsParameters, DTO dto);

}
