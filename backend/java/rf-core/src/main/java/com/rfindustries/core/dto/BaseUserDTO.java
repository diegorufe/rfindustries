package com.rfindustries.core.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseUserDTO implements BaseDTO{

    private String nick;
    private String userName;
    private String firstName;
    private String lastName;

}
