package com.rfindustries.commons.grpc.service;

import com.google.protobuf.UInt64Value;
import com.rfindustries.commons.ScoreSegmentRequest;
import com.rfindustries.commons.ScoreSegmentResponse;
import com.rfindustries.commons.ScoreSegmentServiceGrpc;
import com.rfindustries.commons.service.ValidationService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

@GrpcService
public class ScoreSegmentGrpcService extends ScoreSegmentServiceGrpc.ScoreSegmentServiceImplBase {

    @Autowired
    private ValidationService validationService;

    @Override
    public void calculateScoreSegment(ScoreSegmentRequest request, StreamObserver<ScoreSegmentResponse> responseObserver) {
        validationService.validateIdNumber(request.getIdNumber());

        BigInteger idNumber = new BigInteger(request.getIdNumber().toString());
        int value = 9;
        BigInteger scoreSegment = idNumber.mod(new BigInteger(Integer.toString(value)));
        scoreSegment = scoreSegment.compareTo(BigInteger.ZERO)  == 0 ? BigInteger.ONE : scoreSegment;

        ScoreSegmentResponse response = ScoreSegmentResponse.newBuilder()
                .setScoreSegment(UInt64Value.newBuilder().setValue(scoreSegment.longValue()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
