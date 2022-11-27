package com.rfindustries.core.dto;

public interface BaseDTO {

    default <T> T resolverUserCreatedAtId(){
        return null;
    }

    default <T> T resolverUserUpdatedAtId(){
        return null;
    }
}
