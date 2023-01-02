package com.rfindustries.accounting.constants;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

import java.math.BigDecimal;

public final class EntityDefinition extends BaseJDBCEntityDefinition {

    public static final String TABLE_ACCOUNTING = "RF_ACCOUNTING_ACCOUNTING";
    public static final String TABLE_ACCOUNTING_YEAR = "RF_ACCOUNTING_ACCOUNTING_YEARS";
    public static final String TABLE_LEDGER_ACCOUNT = "RF_ACCOUNTING_LEDGER_ACCOUNTS";
    public static final String TABLE_INVOICE_HEADER = "RF_ACCOUNTING_INVOICE_HEADERS";
    public static final String TABLE_INVOICE_LINE = "RF_ACCOUNTING_INVOICE_LINES";

    public static final String TABLE_CONFIGURATIONS = "RF_ACCOUNTING_CONFIGURATIONS";

    public static final String TABLE_SERIE = "RF_ACCOUNTING_SERIES";

    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String NUMBER = "NUMBER";
    public static final String ACCOUNTING_ID = "ACCOUNTING_ID";
    public static final String ACCOUNTING_YEAR_ID = "ACCOUNTING_YEAR_ID";
    public static final String LEDGER_ACCOUNT_ID = "LEDGER_ACCOUNT_ID";
    public static final String DATE = "DATE";
    public static final String DATE_TIME = "DATE_TIME";
    public static final String TYPE = "TYPE";
    public static final String INVOICE_HEADER_ID = "INVOICE_HEADER_ID";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String AMOUNT = "AMOUNT";
    public static final String TOTAL = "TOTAL";
    public static final String TAX_VERSIONS = "TAX_VERSIONS";
    public static final String TOTAL_BASE = "TOTAL_BASE";
    public static final String TOTAL_TAXES = "TOTAL_TAXES";

    public static final String START_DATE = "START_DATE";
    public static final String END_DATE = "END_DATE";

    private EntityDefinition(){
        // NOT implemented
    }
}
