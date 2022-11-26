package com.rfindustries.corerest.beans;

import com.rfindustries.core.features.ResponseRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

public class ResponseRequestImpl<T> extends ResponseEntity<T> implements ResponseRequest<T> {
    public ResponseRequestImpl(HttpStatusCode status) {
        super(status);
    }

    public ResponseRequestImpl(T body, HttpStatusCode status) {
        super(body, status);
    }

    public ResponseRequestImpl(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public ResponseRequestImpl(T body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers, status);
    }

    public ResponseRequestImpl(T body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public static <T> ResponseRequestImpl<T> ok(@Nullable T body) {
        return (ResponseRequestImpl<T>) ResponseEntity.ok(body);
    }
}
