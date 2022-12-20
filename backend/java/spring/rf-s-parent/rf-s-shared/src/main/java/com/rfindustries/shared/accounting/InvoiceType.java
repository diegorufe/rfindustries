package com.rfindustries.shared.accounting;

public enum InvoiceType {
    PURCHASE(1),
    SALE(2),
    INVESTMENT(3),

    ;

    private Integer value;

    InvoiceType(Integer value) {
        this.value = value;
    }
}
