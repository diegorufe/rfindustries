package com.rfindustries.accounting.service;

import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.dto.OptionInvoiceDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.core.service.BaseCrudHeaderLineService;

public interface InvoiceService
        extends BaseCrudHeaderLineService<
        InvoiceHeaderService, InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO,
        InvoiceLineService, InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO,
        OptionInvoiceDTO
        > {
}
