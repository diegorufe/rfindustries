package com.rfindustries.core.entities;

public abstract class BaseColumnDefinition {
    public static final Column ID = Column.builder().name("id").insertable(false).updatable(false).build();
    public static final Column USER_CREATED_AT_ID = Column.builder().name("userCreatedAtId").insertable(true).updatable(false).build();
    public static final Column USER_UPDATED_AT_ID = Column.builder().name("userUpdatedAtId").build();
    public static final Column CREATED_AT = Column.builder().name("createdAt").insertable(true).updatable(false).build();
    public static final Column UPDATED_AT = Column.builder().name("updatedAt").build();
}
