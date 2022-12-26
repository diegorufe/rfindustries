package com.rfindustries.core.features;

import com.rf.collections.utils.StringUtils;

import java.util.Map;
import java.util.Optional;

public interface BaseCommonsParameters {

    Object getUserId();

    @SuppressWarnings("unchecked")
    default <T> T getUserIdCastToDesire(){
        return (T) this.getUserId();
    }


    Object getBusinessCustomerId();

    @SuppressWarnings("unchecked")
    default <T> T getBusinessCustomerIdCastToDesire(){
        return (T) this.getBusinessCustomerId();
    }

    Object getEnterpriseId();

    @SuppressWarnings("unchecked")
    default <T> T getEnterpriseIdCastToDesire(){
        return (T) this.getEnterpriseId();
    }


     Map<String, Object> getCacheProcess();


    default void clearCacheProcess(){
        this.getCacheProcess().clear();
    }

    default <T> void putCacheProcess(String key, T value){
        if(StringUtils.isNotBlank(key) && value != null){
            this.getCacheProcess().put(key, value);
        }
    }
    @SuppressWarnings("unchecked")
    default <T> Optional<T> getCacheProcess(String key){
        T result = null;

        if(StringUtils.isBlank(key)){

            result = (T) this.getCacheProcess().get(key);
        }

        return Optional.ofNullable(result);
    }
}
