package com.rfindustries.accounting.controllers;

import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.entities.AccountingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private AccountingDao accountingDao;


    @GetMapping("/hello")
    public String helloWorld() {
        AccountingEntity entity = this.accountingDao.save(AccountingEntity.builder().code("TEST").name("ASD").build());
        entity.setName(null);
        this.accountingDao.save(entity);
        entity.setName("EE");
        this.accountingDao.save(entity);
        return this.accountingDao.findAll()+ " Hello World";
    }
}