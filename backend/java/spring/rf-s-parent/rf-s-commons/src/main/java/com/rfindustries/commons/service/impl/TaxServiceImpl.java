package com.rfindustries.commons.service.impl;

import com.rfindustries.commons.dao.TaxDao;
import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.commons.service.TaxService;
import com.rfindustries.commons.utils.CommonsMapperUtils;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl extends BaseTransactionalCrudServiceImpl<TaxDao, TaxEntity, Long, TaxDTO>
        implements TaxService {

    @Override
    public TaxEntity toEntity(TaxDTO dto) {
        return CommonsMapperUtils.toTaxEntity(dto);
    }

    @Override
    public TaxDTO toDTO(TaxEntity entity) {
        return CommonsMapperUtils.toTaxDTO(entity);
    }

    @Override
    public TaxDTO instanceDTO() {
        return TaxDTO.builder().build();
    }
}
