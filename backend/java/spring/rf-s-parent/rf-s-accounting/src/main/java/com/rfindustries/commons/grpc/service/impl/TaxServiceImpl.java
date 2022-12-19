package com.rfindustries.commons.grpc.service.impl;

import com.rfindustries.shared.commons.service.TaxGrpcService;
import com.rfindustries.shared.commons.service.impl.TaxGrpcServiceImpl;
import com.rfindustries.shared.proto.TaxServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl extends TaxGrpcServiceImpl implements TaxGrpcService {

    @GrpcClient("taxes")
    private TaxServiceGrpc.TaxServiceFutureStub futureStub;

    @Override
    public TaxServiceGrpc.TaxServiceFutureStub getFutureStub() {
        return futureStub;
    }
}
