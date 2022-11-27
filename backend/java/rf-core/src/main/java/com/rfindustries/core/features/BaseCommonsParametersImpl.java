package com.rfindustries.core.features;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseCommonsParametersImpl implements BaseCommonsParameters{

    private Long userId;
    private Long businessCustomerId;
    private Long enterpriseId;

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
}
