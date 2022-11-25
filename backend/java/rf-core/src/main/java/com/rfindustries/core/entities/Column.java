package com.rfindustries.core.entities;

import com.rfindustries.core.entities.BaseColumn;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class Column implements BaseColumn {

    private final String name;

    private final boolean insertable;

    private final boolean updatable;

    public Column(String name) {
      this(name, true, true);
    }

    public Column(String name, boolean insertable, boolean updatable) {
        this.name = name;
        this.insertable = insertable;
        this.updatable = updatable;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
