package com.rfindustries.core.beans.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public final class Field {

    private String name;

    public Field(String name) {
        this.name = name;
    }
}
