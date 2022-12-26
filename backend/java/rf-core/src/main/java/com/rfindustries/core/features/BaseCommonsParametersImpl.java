package com.rfindustries.core.features;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class BaseCommonsParametersImpl implements BaseCommonsParameters{

    private Long userId;
    private Long businessCustomerId;
    private Long enterpriseId;

    @Builder.Default
    private Map<String, Object> cacheProcess = new HashMap<>();

    @Override
    public Object getUserId() {
        return this.userId;
    }

    @Override
    public Object getBusinessCustomerId() {
        return this.businessCustomerId;
    }

    @Override
    public Object getEnterpriseId() {
        return this.enterpriseId;
    }

    @Override
    public Map<String, Object> getCacheProcess() {
        return cacheProcess;
    }
}
