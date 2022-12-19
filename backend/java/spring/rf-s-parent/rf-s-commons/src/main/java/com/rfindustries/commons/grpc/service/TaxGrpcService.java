package com.rfindustries.commons.grpc.service;

import com.google.protobuf.Int64Value;
import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.service.TaxService;
import com.rfindustries.shared.proto.*;
import com.rfindustries.shared.utils.ProtoUtils;
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

        Tax.Builder taxBuilder = Tax.newBuilder()
                .setId(taxDTO.getId())
                .setCode(taxDTO.getCode())
                .setName(taxDTO.getName())
                .setBusinessCustomerId(taxDTO.getBusinessCustomerId());

        if(taxDTO.getEnterpriseId() != null){
            taxBuilder.setEnterpriseId(ProtoUtils.toInt64Value(taxDTO.getEnterpriseId()));
        }

        Tax tax = taxBuilder.build();

        responseObserver.onNext(tax);
        responseObserver.onCompleted();
    }

    @Override
    public void findAllTaxes(FindAllTaxesRequest request, StreamObserver<ListTax> responseObserver) {
        // TODO
        super.findAllTaxes(request, responseObserver);
    }
}
