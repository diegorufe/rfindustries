package com.rfindustries.core.features;

public interface BaseCommonsParameters {

    Object getUserId();

    @SuppressWarnings("unchecked")
    default <T> T getUserIdCastToDesire(){
        return (T) this.getUserId();
    }
}
