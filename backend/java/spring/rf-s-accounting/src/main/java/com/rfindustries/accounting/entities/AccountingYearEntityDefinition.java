package com.rfindustries.accounting.entities;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public abstract class AccountingYearEntityDefinition extends BaseJDBCEntityDefinition {
    public static final String TABLE = "RF_ACCOUNTING_ACCOUNTING_YEARS";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String ACCOUNTING_ID = "ACCOUNTING_ID";
    public static final String START_DATE = "START_DATE";
    public static final String END_DATE = "END_DATE";
}
