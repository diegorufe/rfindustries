package com.rfindustries.accounting;


import com.rfindustries.core.constansts.RFConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(RFConstants.PACKAGE_COMPONENT_SCAN)
public class AccountingApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccountingApplication.class, args);
    }

}
