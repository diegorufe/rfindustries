package com.rfindustries.accounting.service;

import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.core.service.BaseCrudService;

public interface InvoiceLineService extends BaseCrudService<InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO> {

}
