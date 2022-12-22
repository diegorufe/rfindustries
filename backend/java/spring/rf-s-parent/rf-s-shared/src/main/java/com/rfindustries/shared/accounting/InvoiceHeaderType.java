package com.rfindustries.shared.accounting;

import java.util.Arrays;

public enum InvoiceHeaderType {
    PURCHASE((byte) 1),
    SALE((byte)2),
    INVESTMENT((byte)3),

    ;

    private final byte type;

    InvoiceHeaderType(byte value) {
        this.type = value;
    }

    public byte getType() {
        return type;
    }

    public static  InvoiceHeaderType getByType(byte type){
        return Arrays.stream(values()).filter(v-> v.getType() == type).findFirst().orElse(InvoiceHeaderType.PURCHASE);
    }
}
