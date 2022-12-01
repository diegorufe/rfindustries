package com.rfindustries.accounting.controllers;

import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.accounting.service.AccountingService;
import com.rfindustries.corerest.controllers.BaseRestCrudControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountingService.ROUTE)
public class AccountingRestController extends BaseRestCrudControllerImpl<AccountingService, AccountingDao, AccountingEntity, Long, AccountingDTO> {
}
