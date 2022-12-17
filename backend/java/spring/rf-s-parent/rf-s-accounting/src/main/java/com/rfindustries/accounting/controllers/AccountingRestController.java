package com.rfindustries.accounting.controllers;

import com.rfindustries.accounting.dao.AccountingDao;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.accounting.service.AccountingService;
import com.rfindustries.corerest.controllers.BaseRestCrudControllerImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping(AccountingService.ROUTE)
public class AccountingRestController extends BaseRestCrudControllerImpl<AccountingService, AccountingDao, AccountingEntity, Long, AccountingDTO> {

    @GetMapping("/text-file")
    public ResponseEntity<StreamingResponseBody> streamContentAsFile() {
        StreamingResponseBody responseBody = response -> {
            StringBuilder file = new StringBuilder();
            for (int i = 1; i <= 1000; i++) {
                file.append("Data stream line - ").append(i).append("\n");
            }
            byte[] filedData = file.toString().getBytes();
            for (byte filedDatum : filedData) {
                response.write(filedDatum);
                response.flush();
            }
        };
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test_data.txt")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(responseBody);
    }
}
