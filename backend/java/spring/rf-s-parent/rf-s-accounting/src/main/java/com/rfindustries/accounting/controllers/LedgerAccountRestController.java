package com.rfindustries.accounting.controllers;

import com.rfindustries.accounting.dao.LedgerAccountDao;
import com.rfindustries.accounting.dto.LedgerAccountDTO;
import com.rfindustries.accounting.entities.LedgerAccountEntity;
import com.rfindustries.accounting.service.LedgerAccountService;
import com.rfindustries.corerest.controller.impl.BaseRestCrudControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LedgerAccountService.ROUTE)
public class LedgerAccountRestController extends BaseRestCrudControllerImpl<LedgerAccountService, LedgerAccountDao, LedgerAccountEntity, Long, LedgerAccountDTO> {


}
