package com.rfindustries.corejdbc.entities;

import com.rf.collections.builders.MapBuilder;
import com.rfindustries.core.entities.BaseColumnDefinition;
import com.rfindustries.core.entities.Column;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseJDBCColumnDefinition extends BaseColumnDefinition {

    public static final Map<String, Column> COLUMNS =
            new MapBuilder<String, Column>(new HashMap<>())
                    .add(CREATED_AT.getName(), CREATED_AT)
                    .add(UPDATED_AT.getName(), UPDATED_AT)
                    .add(USER_CREATED_AT_ID.getName(), USER_CREATED_AT_ID)
                    .add(USER_UPDATED_AT_ID.getName(), USER_UPDATED_AT_ID)
                    .getMap();
}
