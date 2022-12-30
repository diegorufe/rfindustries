package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.SerieDao;
import com.rfindustries.accounting.dto.SerieDTO;
import com.rfindustries.accounting.entities.SerieEntity;
import com.rfindustries.accounting.service.SerieService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SerieServiceImpl extends BaseTransactionalCrudServiceImpl<SerieDao, SerieEntity, Long, SerieDTO>
        implements SerieService {

    @Override
    public SerieEntity toEntity(BaseCommonsParameters baseCommonsParameters, SerieDTO dto) {
        return AccountingMapperUtils.toSerieEntity(dto);
    }

    @Override
    public SerieDTO toDTO(BaseCommonsParameters baseCommonsParameters, SerieEntity entity) {
        return AccountingMapperUtils.toSerieDTO(entity);
    }

    @Override
    public SerieDTO instanceDTO() {
        return SerieDTO.builder().build();
    }
}
