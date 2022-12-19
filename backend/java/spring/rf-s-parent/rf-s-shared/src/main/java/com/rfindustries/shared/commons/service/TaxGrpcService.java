package com.rfindustries.shared.commons.service;

import com.rfindustries.shared.commons.dto.TaxDTO;
import com.rfindustries.shared.proto.TaxServiceGrpc;

import java.util.List;

public interface TaxGrpcService {


    TaxServiceGrpc.TaxServiceFutureStub getFutureStub();

    TaxDTO findById(Long id);

    List<TaxDTO> findAll(Long businessCustomerId, Long enterpriseId);

}
