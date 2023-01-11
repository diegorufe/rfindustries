package com.rfindustries.preferences.controllers;

import com.rfindustries.corereactiverest.controller.impl.BaseReactiveRestCrudControllerImpl;
import com.rfindustries.preferences.dao.BrowserDao;
import com.rfindustries.preferences.dto.BrowserDTO;
import com.rfindustries.preferences.entities.BrowserEntity;
import com.rfindustries.preferences.service.BrowserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BrowserService.ROUTE)
public class BrowserRestController extends BaseReactiveRestCrudControllerImpl<BrowserService, BrowserDao, BrowserEntity, String, BrowserDTO> {
}
