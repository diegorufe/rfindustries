package com.rfindustries.accounting.constants;

import com.rfindustries.core.features.CalculationType;

public enum CalculationInvoiceType implements CalculationType {

    ADD_LINE,

    CALCULATE_TOTAL_LINE,

    CALCULATE_TOTAL_INVOICE,

    FIND_TAX_VERSION,

    RECALCULATE_LINES

    ;

    @Override
    public String getType() {
        return this.name();
    }
}
