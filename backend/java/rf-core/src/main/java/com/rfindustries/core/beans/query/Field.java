package com.rfindustries.core.beans.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Field {

    private String name;

    public Field(String name) {
        this.name = name;
    }
}
