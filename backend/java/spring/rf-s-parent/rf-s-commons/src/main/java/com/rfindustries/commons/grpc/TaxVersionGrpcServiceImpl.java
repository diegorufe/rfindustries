package com.rfindustries.commons.grpc;

import com.rfindustries.commons.service.TaxVersionService;
import com.rfindustries.shared.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class TaxVersionGrpcServiceImpl extends TaxVersionServiceGrpc.TaxVersionServiceImplBase {

    @Autowired
    private TaxVersionService taxVersionService;

    @Override
    public void findTaxVersionByTaxIdAndDate(FindTaxVersionRequest request, StreamObserver<TaxVersion> responseObserver) {
        // TODO find taxversion by id and date
        super.findTaxVersionByTaxIdAndDate(request, responseObserver);
    }

    @Override
    public void findTaxVersionsByIds(FindTaxVersionByIdsRequest request, StreamObserver<ListTaxVersion> responseObserver) {
        // TODO find tax versions by ids
        super.findTaxVersionsByIds(request, responseObserver);
    }
}
