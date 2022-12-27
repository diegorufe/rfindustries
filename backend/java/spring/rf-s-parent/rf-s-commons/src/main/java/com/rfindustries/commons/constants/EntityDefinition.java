package com.rfindustries.commons.constants;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public final class EntityDefinition extends BaseJDBCEntityDefinition {

    public static final String TABLE_TAX = "RF_COMMONS_TAXES";
    public static final String TABLE_TAX_VERSION = "RF_COMMONS_TAXES_VERSIONS";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String START_DATE = "START_DATE";
    public static final String RATE = "RATE";
    public static final String TAX_ID = "TAX_ID";
    public static final String TYPE = "TYPE";
    public static final String VALUE = "VALUE";

    private EntityDefinition(){
        // NOT implemented
    }
}
