package com.rfindustries.core.service;

import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.utils.ResponseMethodUtils;

public interface BaseService {

    default void mergeMessagesResponseMethod(ResponseMethod<?> a, ResponseMethod<?> b) {
        ResponseMethodUtils.mergeMessagesResponseMethod(a, b);
    }
}
