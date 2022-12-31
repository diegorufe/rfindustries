package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.constants.SerieType;
import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.service.InvoiceHeaderService;
import com.rfindustries.accounting.service.SerieService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceHeaderServiceImpl extends BaseTransactionalCrudServiceImpl<InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO>
        implements InvoiceHeaderService {

    @Autowired
    private SerieService serieService;


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

    @Override
    public ResponseMethod<InvoiceHeaderDTO> actionDoBeforeInsertUpdate(BaseCommonsParameters baseCommonsParameters, InvoiceHeaderDTO dto, boolean insert) {
        // increment serie
        this.serieService.incrementNumber(baseCommonsParameters, SerieType.getByType(dto.getType().getType()), dto.getCode(), dto.getNumber());
        return super.actionDoBeforeInsertUpdate(baseCommonsParameters, dto, insert);
    }

    @Override
    public ResponseMethod<InvoiceHeaderDTO> actionDoBeforeDelete(BaseCommonsParameters baseCommonsParameters, InvoiceHeaderDTO dto) {
        // decrement serie
        this.serieService.decrementNumber(baseCommonsParameters, SerieType.getByType(dto.getType().getType()), dto.getCode(), dto.getNumber());
        return super.actionDoBeforeDelete(baseCommonsParameters, dto);
    }
}
