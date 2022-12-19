package com.rfindustries.shared.commons.service.impl;

import com.google.common.util.concurrent.ListenableFuture;
import com.rfindustries.shared.commons.service.TaxVersionGrpcService;
import com.rfindustries.shared.proto.FindTaxVersionRequest;
import com.rfindustries.shared.proto.TaxVersion;
import com.rfindustries.shared.utils.ProtoUtils;

import java.time.LocalDate;
import java.util.Optional;

public abstract class TaxVersionGrpcServiceImpl implements TaxVersionGrpcService {

    @Override
    public Optional<TaxVersion> findByTaxIdAndDate(Long taxId, LocalDate date) {
        FindTaxVersionRequest findTaxVersionRequest = FindTaxVersionRequest.newBuilder()
                .setTaxId(taxId)
                .setDate(ProtoUtils.toGoogleDate(date))
                .build();
        ListenableFuture<TaxVersion> listenableFuture = this.getFutureStub().findTaxVersionByTaxIdAndDate(findTaxVersionRequest);
        return Optional.of(ProtoUtils.get(listenableFuture));
    }
}
