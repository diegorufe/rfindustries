package com.rfindustries.commons.grpc.service.impl;

import com.rfindustries.shared.commons.service.TaxVersionGrpcService;
import com.rfindustries.shared.commons.service.impl.TaxVersionGrpcServiceImpl;
import com.rfindustries.shared.proto.TaxVersionServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;

public class TaxVersionServiceImpl extends TaxVersionGrpcServiceImpl implements TaxVersionGrpcService {

    @GrpcClient("taxesVersions")
    private TaxVersionServiceGrpc.TaxVersionServiceFutureStub futureStub;

    @Override
    public TaxVersionServiceGrpc.TaxVersionServiceFutureStub getFutureStub() {
        return this.futureStub;
    }
}
