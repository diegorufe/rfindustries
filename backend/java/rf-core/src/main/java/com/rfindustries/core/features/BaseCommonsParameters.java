package com.rfindustries.core.features;

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

}
