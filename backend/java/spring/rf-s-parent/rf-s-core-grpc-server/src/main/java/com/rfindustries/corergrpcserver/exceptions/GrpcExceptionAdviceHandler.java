package com.rfindustries.corergrpcserver.exceptions;

import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

/**
 * <a href="https://github.com/senoritadeveloper01/nils-spring-microservices-grpc/blob/master/city-score/src/main/java/com/nils/microservices/cityscore/exception/CityScoreExceptionHandler.java">...</a>
 */
@GrpcAdvice
public class GrpcExceptionAdviceHandler {


    @GrpcExceptionHandler(Throwable.class)
    public StatusRuntimeException handler(Throwable throwable) {


//        Status status = Status.newBuilder()
//                .setCode(500)
//                .setMessage("Error ")
//                .addDetails(Any.pack(exceptionResponse))
//                .build();

        Status status = Status.newBuilder()
                .setCode(500)
                .setMessage(throwable.getMessage())
                .build();

        return StatusProto.toStatusRuntimeException(status);

    }
}
