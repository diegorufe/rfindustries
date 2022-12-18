package com.rfindustries.shared.commons.service.impl;

import com.rfindustries.shared.commons.dto.TaxDTO;
import com.rfindustries.shared.commons.service.TaxGrpcService;
import com.rfindustries.shared.proto.FindByIdTaxRequest;
import com.rfindustries.shared.proto.Tax;

import java.util.List;

public abstract class TaxGrpcServiceImpl implements TaxGrpcService {

    @Override
    public TaxDTO findById(Long id) {
        FindByIdTaxRequest findByIdTaxRequest = FindByIdTaxRequest.newBuilder().setId(id).build();
        Tax tax = this.getStub().findTaxById(findByIdTaxRequest);
        return TaxDTO.fromTax(tax);
    }

    @Override
    public List<TaxDTO> findAll(Long businessCustomerId, Long enterpriseId) {
        // TODO implement
        return null;
    }
}
