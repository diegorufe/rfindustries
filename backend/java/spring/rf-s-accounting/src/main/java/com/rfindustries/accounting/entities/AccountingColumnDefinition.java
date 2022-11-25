package com.rfindustries.accounting.entities;

import com.rf.collections.builders.MapBuilder;
import com.rfindustries.core.entities.Column;
import com.rfindustries.corejdbc.entities.BaseJDBCColumnDefinition;

import java.util.HashMap;
import java.util.Map;

public abstract class AccountingColumnDefinition extends BaseJDBCColumnDefinition {
    public static final Column CODE = Column.builder().name("code").build();
    public static final Column NAME = Column.builder().name("name").build();;

    public static final Map<String, Column> COLUMNS =
            new MapBuilder<String, Column>(new HashMap<>())
                    .add(BaseJDBCColumnDefinition.COLUMNS)
                    .add(CODE.getName(), CODE)
                    .add(NAME.getName(), NAME)
                    .getMap();

}
