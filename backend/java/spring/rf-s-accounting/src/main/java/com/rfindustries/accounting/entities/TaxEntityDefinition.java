package com.rfindustries.accounting.entities;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public abstract class TaxEntityDefinition extends BaseJDBCEntityDefinition {
    public static final String TABLE = "RF_ACCOUNTING_TAXES";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String START_DATE = "START_DATE";
}
