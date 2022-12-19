package com.rfindustries.shared.commons.service;

import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import com.rfindustries.shared.proto.TaxVersion;
import com.rfindustries.shared.proto.TaxVersionServiceGrpc;

import java.time.LocalDate;
import java.util.Optional;

public interface TaxVersionGrpcService {

    TaxVersionServiceGrpc.TaxVersionServiceFutureStub getFutureStub();

    Optional<TaxVersionDTO> findByTaxIdAndDate(Long taxId, LocalDate date);
}
