package com.rfindustries.core.beans;

import com.rfindustries.core.constansts.MessageLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private MessageLevel level;
    private String text;
    private String supportMessage;
}
