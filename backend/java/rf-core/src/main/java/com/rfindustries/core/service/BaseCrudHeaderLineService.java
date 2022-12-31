package com.rfindustries.core.service;

import com.rfindustries.core.beans.ResponseMethod;
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
        > extends BaseService {


    HEADER_SERVICE getHeaderService();

    LINE_SERVICE getLineService();

    DTO instanceDTO();

    ResponseMethod<DTO> goAdd(BaseCommonsParameters baseCommonsParameters);

    ResponseMethod<DTO> goRead(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk);

    ResponseMethod<DTO> goEdit(BaseCommonsParameters baseCommonsParameters, HEADER_PK headerPk);

    ResponseMethod<DTO> upsert(BaseCommonsParameters baseCommonsParameters, DTO dto, boolean insert);

    ResponseMethod<Boolean> delete(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ResponseMethod<DTO> addLine(BaseCommonsParameters baseCommonsParameters, DTO dto);

    ResponseMethod<DTO> calculate(BaseCommonsParameters baseCommonsParameters, DTO dto);

}
