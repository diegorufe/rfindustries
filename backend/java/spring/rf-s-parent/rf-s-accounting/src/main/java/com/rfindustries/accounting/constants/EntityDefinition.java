package com.rfindustries.accounting.constants;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public final class EntityDefinition extends BaseJDBCEntityDefinition {

    public static final String TABLE_ACCOUNTING = "RF_ACCOUNTING_ACCOUNTING";
    public static final String TABLE_ACCOUNTING_YEAR = "RF_ACCOUNTING_ACCOUNTING_YEARS";
    public static final String TABLE_LEDGER_ACCOUNT = "RF_ACCOUNTING_LEDGER_ACCOUNTS";

    public static final String CODE = "CODE";
    public static final String NAME = "NAME";



    private EntityDefinition(){
        // NOT implemented
    }
}
