package com.rfindustries.core.beans.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CacheKey<PK_BUSINESS_CUSTOMER, PK_ENTERPRISE> implements Serializable {

    private PK_ENTERPRISE pkEnterprise;
    private PK_BUSINESS_CUSTOMER pkBusinessCustomer;

}
