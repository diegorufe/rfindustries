package com.rfindustries.accounting.controllers;

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
import com.rfindustries.corerest.controller.impl.BaseRestHeaderLineCrudControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(InvoiceService.ROUTE)
public class InvoiceRestController extends BaseRestHeaderLineCrudControllerImpl<
        InvoiceService,
        InvoiceDTO,
        InvoiceHeaderService,
        InvoiceHeaderDao,
        InvoiceHeaderEntity,
        Long,
        InvoiceHeaderDTO,
        InvoiceLineService,
        InvoiceLineDao,
        InvoiceLineEntity,
        Long,
        InvoiceLineDTO,
        OptionInvoiceDTO
        > {
}
