package com.rfindustries.accounting.service;

import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.core.service.BaseCrudService;

import java.util.List;

public interface InvoiceLineService extends BaseCrudService<InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO> {

    List<InvoiceLineDTO> findAllByInvoiceId(Long invoiceId);
}
