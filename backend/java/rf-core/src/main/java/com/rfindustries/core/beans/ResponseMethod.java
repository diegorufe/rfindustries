package com.rfindustries.core.beans;

import com.rfindustries.core.constansts.MessageLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMethod<T> {
    private T data;
    private Map<MessageLevel, List<Message>> messages;
}
