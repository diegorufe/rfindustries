package com.rfindustries.core.entities;

public interface BaseColumn {
    String getName();

    boolean isInsertable();

    boolean isUpdatable();
}
