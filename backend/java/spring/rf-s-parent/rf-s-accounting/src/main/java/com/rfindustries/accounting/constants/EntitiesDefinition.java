package com.rfindustries.accounting.constants;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public final class EntitiesDefinition extends BaseJDBCEntityDefinition {

    public static final String TABLE_ACCOUNTING = "RF_ACCOUNTING_ACCOUNTING";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";

    public static final String TABLE_ACCOUNTING_YEAR = "RF_ACCOUNTING_ACCOUNTING_YEARS";

    private EntitiesDefinition(){
        // NOT implemented
    }
}
