package com.rfindustries.commons.grpc;

import com.rfindustries.commons.service.TaxVersionService;
import com.rfindustries.shared.proto.FindTaxVersionRequest;
import com.rfindustries.shared.proto.TaxVersion;
import com.rfindustries.shared.proto.TaxVersionServiceGrpc;
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
}
