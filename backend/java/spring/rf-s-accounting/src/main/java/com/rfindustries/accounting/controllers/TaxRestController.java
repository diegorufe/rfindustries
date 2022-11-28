package com.rfindustries.accounting.controllers;

import com.rfindustries.accounting.dao.TaxDao;
import com.rfindustries.accounting.dto.TaxDTO;
import com.rfindustries.accounting.entities.TaxEntity;
import com.rfindustries.accounting.service.TaxService;
import com.rfindustries.corerest.controllers.BaseRestCrudControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TaxService.ROUTE)
public class TaxRestController extends BaseRestCrudControllerImpl<TaxService, TaxDao, TaxEntity, Long, TaxDTO> {
}
