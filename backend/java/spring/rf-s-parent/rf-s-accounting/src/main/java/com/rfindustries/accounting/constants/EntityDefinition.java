package com.rfindustries.accounting.constants;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public final class EntityDefinition extends BaseJDBCEntityDefinition {

    public static final String TABLE_ACCOUNTING = "RF_ACCOUNTING_ACCOUNTING";
    public static final String TABLE_ACCOUNTING_YEAR = "RF_ACCOUNTING_ACCOUNTING_YEARS";
    public static final String TABLE_LEDGER_ACCOUNT = "RF_ACCOUNTING_LEDGER_ACCOUNTS";

    public static final String TABLE_INVOICE_HEADER = "RF_ACCOUNTING_INVOICE_HEADERS";

    public static final String TABLE_INVOICE_LINE = "RF_ACCOUNTING_INVOICE_LINES";

    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String NUMBER = "NUMBER";
    public static final String ACCOUNTING_ID = "ACCOUNTING_ID";
    public static final String ACCOUNTING_YEAR_ID = "ACCOUNTING_YEAR_ID";
    public static final String LEDGER_ACCOUNT_ID = "LEDGER_ACCOUNT_ID";
    public static final String DATE = "DATE";
    public static final String DATE_TIME = "DATE_TIME";

    private EntityDefinition(){
        // NOT implemented
    }
}
