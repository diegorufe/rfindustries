package com.rfindustries.commons.grpc.service;

import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.service.TaxService;
import com.rfindustries.shared.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class TaxGrpcService extends TaxServiceGrpc.TaxServiceImplBase {

    @Autowired
    private TaxService taxService;

    @Override
    public void findTaxById(FindByIdTaxRequest request, StreamObserver<Tax> responseObserver) {
        TaxDTO taxDTO = taxService.findById(request.getId());

        Tax tax = Tax.newBuilder()
                .setId(taxDTO.getId())
                .setCode(taxDTO.getCode())
                .setName(taxDTO.getName())
                .setBusinessCustomerId(taxDTO.getBusinessCustomerId())
                .setEnterpriseId(taxDTO.getEnterpriseId())
                .build();

        responseObserver.onNext(tax);
        responseObserver.onCompleted();
    }

    @Override
    public void findAllTaxes(FindAllTaxesRequest request, StreamObserver<ListTax> responseObserver) {
        // TODO
        super.findAllTaxes(request, responseObserver);
    }
}
