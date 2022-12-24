package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceDTO;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.dto.OptionInvoiceDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceHeaderService;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.accounting.service.InvoiceService;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudHeaderLineServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InvoiceServiceImpl
        extends BaseTransactionalCrudHeaderLineServiceImpl<
        InvoiceDTO,
        InvoiceHeaderService, InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO,
        InvoiceLineService, InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO,
        OptionInvoiceDTO
        > implements InvoiceService {

    @Override
    public InvoiceDTO instanceDTO() {
        return InvoiceDTO.builder()
                .header(this.getHeaderService().instanceDTO())
                .lines(new ArrayList<>())
                .options(OptionInvoiceDTO.builder().build())
                .build();
    }
}
