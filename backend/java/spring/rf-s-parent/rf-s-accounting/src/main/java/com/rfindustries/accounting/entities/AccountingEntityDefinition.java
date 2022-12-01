package com.rfindustries.accounting.entities;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public abstract class AccountingEntityDefinition extends BaseJDBCEntityDefinition {
    public static final String TABLE = "RF_ACCOUNTING_ACCOUNTING";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
}
