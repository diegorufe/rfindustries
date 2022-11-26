package com.rfindustries.core.beans.rest;

import com.rfindustries.core.beans.Message;
import com.rfindustries.core.constansts.MessageLevel;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class BodyResponseRequest<T> {
    private T data;
    private Map<MessageLevel, List<Message>> messages;

    /**
     * Método para añadir mensajes a una respuesta
     *
     * @param message a añadir a una respuesta
     */
    public void addMessage(Message message) {
        if (messages == null) {
            messages = new HashMap<>();
        }

        List<Message> messagesResponse;

        if (messages.containsKey(message.getLevel())) {
            messagesResponse = messages.get(message.getLevel());
        } else {
            messagesResponse = new ArrayList<>();
            messages.put(message.getLevel(), messagesResponse);
        }

        messagesResponse.add(message);

    }
}
