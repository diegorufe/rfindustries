package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.service.InvoiceHeaderService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InvoiceHeaderServiceImpl extends BaseTransactionalCrudServiceImpl<InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO>
        implements InvoiceHeaderService {

    @Override
    public InvoiceHeaderEntity toEntity(BaseCommonsParameters baseCommonsParameters, InvoiceHeaderDTO dto) {
        return AccountingMapperUtils.toInvoiceHeaderEntity(dto);
    }

    @Override
    public InvoiceHeaderDTO toDTO(BaseCommonsParameters baseCommonsParameters, InvoiceHeaderEntity entity) {
        return AccountingMapperUtils.toInvoiceHeaderDTO(entity);
    }

    @Override
    public InvoiceHeaderDTO instanceDTO() {
        return InvoiceHeaderDTO.builder().build();
    }

    @Override
    public int updateTotals(InvoiceHeaderDTO dto) {
        return dto == null ? -1 : this.getDao().updateTotals(dto.getId(), dto.getTotalBase(), dto.getTotalTaxes(), dto.getTotal());
    }
}
