package com.rfindustries.commons.constants;

import com.rfindustries.corejdbc.entities.BaseJDBCEntityDefinition;

public final class EntitiesDefinition extends BaseJDBCEntityDefinition {

    public static final String TABLE_TAX = "RF_COMMONS_TAXES";
    public static final String TABLE_TAX_VERSION = "RF_COMMONS_TAXES_VERSIONS";
    public static final String CODE = "CODE";
    public static final String NAME = "NAME";
    public static final String START_DATE = "START_DATE";
    public static final String RATE = "RATE";

    private EntitiesDefinition(){
        // NOT implemented
    }
}
