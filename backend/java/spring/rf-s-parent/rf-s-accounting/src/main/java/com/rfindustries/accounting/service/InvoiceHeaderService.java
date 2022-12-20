package com.rfindustries.accounting.service;

import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.core.service.BaseCrudService;

public interface InvoiceHeaderService extends BaseCrudService<InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO> {

}
