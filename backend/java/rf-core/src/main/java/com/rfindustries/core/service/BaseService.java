package com.rfindustries.core.service;

import com.rfindustries.core.beans.ResponseMethod;

import java.util.HashMap;

public interface BaseService {

    default void mergeMessagesResponseMethod(ResponseMethod<?> a, ResponseMethod<?> b) {
        if (a != null && b != null) {
            if (a.getMessages() == null) {
                a.setMessages(new HashMap<>());
            }
            if (b.getMessages() != null) {
                b.getMessages().forEach((k, v) -> {
                    if (a.getMessages().containsKey(k)) {
                        a.getMessages().get(k).addAll(v);
                    } else {
                        a.getMessages().put(k, v);
                    }
                });
            }
        }
    }
}
