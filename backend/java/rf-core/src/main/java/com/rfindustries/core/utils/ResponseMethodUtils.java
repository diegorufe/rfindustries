package com.rfindustries.core.utils;

import com.rfindustries.core.beans.ResponseMethod;

import java.util.HashMap;

public final class ResponseMethodUtils {

    private ResponseMethodUtils() {
        // NOT implemented
    }

    public static void mergeMessagesResponseMethod(ResponseMethod<?> a, ResponseMethod<?> b) {
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
