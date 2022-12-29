package com.rfindustries.core.utils;

import com.rfindustries.core.beans.cache.CacheValue;
import com.rfindustries.core.constansts.SchedulingConstants;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class CacheUtils {

    private CacheUtils() {
        // NOT implemented
    }

    public static <PK, SK, V> void clearValuesCache(ConcurrentHashMap<PK, ConcurrentHashMap<SK, CacheValue<V>>> mapValues) {
        long now = System.currentTimeMillis();
        mapValues.forEach((k, v) -> {
            if (v != null) {
                v.forEach((kt, vt) -> {
                    if (vt != null && now - vt.getLastAccessTime() > SchedulingConstants.TIME_CLEAR_CACHE) {
                        v.remove(kt);
                    }
                });
            }
        });
    }

    public static <PK, SK, V> Optional<V> findCacheValue(PK pk, ConcurrentHashMap<PK, ConcurrentHashMap<SK, CacheValue<V>>> mapValues, SK sk) {
        V value = null;

        if (pk != null) {
            ConcurrentHashMap<SK, CacheValue<V>> cacheTaxVersions = mapValues.getOrDefault(pk, null);

            if (sk != null && cacheTaxVersions != null && cacheTaxVersions.containsKey(sk)) {
                value = cacheTaxVersions.get(sk).getAndAudit();
            }
        }

        return Optional.ofNullable(value);
    }

    public static <PK, SK, V> V putCacheValue(PK pk, ConcurrentHashMap<PK, ConcurrentHashMap<SK, CacheValue<V>>> mapValues, V value, SK sk) {
        if (pk != null && value != null) {
            ConcurrentHashMap<SK, CacheValue<V>> cacheTaxVersions = mapValues.getOrDefault(pk, null);
            boolean addMap = false;

            if (cacheTaxVersions == null) {
                cacheTaxVersions = new ConcurrentHashMap<>();
                addMap = true;
            }
            cacheTaxVersions.put(sk, new CacheValue<>(value));

            if (addMap) {
                mapValues.put((PK) pk, cacheTaxVersions);
            }
        }
        return value;
    }

    public static <PK, SK, V> Optional<V> findCacheValueBusinessCustomer(BaseCommonsParameters baseCommonsParameters, ConcurrentHashMap<PK, ConcurrentHashMap<SK, CacheValue<V>>> mapValues, SK id) {
        return baseCommonsParameters == null || baseCommonsParameters.getBusinessCustomerId() == null ? Optional.empty() : findCacheValue((PK) baseCommonsParameters.getBusinessCustomerId(), mapValues, id);
    }


    public static <PK, SK, V> V putCacheValueBusinessCustomer(BaseCommonsParameters baseCommonsParameters, ConcurrentHashMap<PK, ConcurrentHashMap<SK, CacheValue<V>>> mapValues, V value, SK sk) {
        return baseCommonsParameters == null || baseCommonsParameters.getBusinessCustomerId() == null ? value : putCacheValue((PK) baseCommonsParameters.getBusinessCustomerId(), mapValues, value, sk);
    }
}
