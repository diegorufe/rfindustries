package com.rfindustries.accounting.controllers;

import com.rfindustries.accounting.dao.AccountingYearDao;
import com.rfindustries.accounting.dto.AccountingYearDTO;
import com.rfindustries.accounting.entities.AccountingYearEntity;
import com.rfindustries.accounting.service.AccountingYearService;
import com.rfindustries.shared.BaseRestCrudControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountingYearService.ROUTE)
public class AccountingYearRestController extends BaseRestCrudControllerImpl<AccountingYearService, AccountingYearDao, AccountingYearEntity, Long, AccountingYearDTO> {
}
