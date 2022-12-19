package com.rfindustries.shared.commons.service.impl;

import com.google.common.util.concurrent.ListenableFuture;
import com.rfindustries.shared.commons.dto.TaxDTO;
import com.rfindustries.shared.commons.service.TaxGrpcService;
import com.rfindustries.shared.proto.FindByIdTaxRequest;
import com.rfindustries.shared.proto.Tax;
import com.rfindustries.shared.utils.ProtoUtils;

import java.util.List;

public abstract class TaxGrpcServiceImpl implements TaxGrpcService {

    @Override
    public TaxDTO findById(Long id) {
        FindByIdTaxRequest findByIdTaxRequest = FindByIdTaxRequest.newBuilder().setId(id).build();
        ListenableFuture<Tax> listenableFuture = this.getFutureStub().findTaxById(findByIdTaxRequest);
        return TaxDTO.fromTax(ProtoUtils.get(listenableFuture));
    }

    @Override
    public List<TaxDTO> findAll(Long businessCustomerId, Long enterpriseId) {
        // TODO implement
        return null;
    }
}
