package com.rfindustries.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseUserDTO implements BaseDTO{

    private String nick;
    private String userName;
    private String firstName;
    private String lastName;

}
