package com.rfindustries.shared.accounting;

import java.util.Arrays;

public enum InvoiceLineType {

    NORMAL((byte) 1),
    TEXT((byte)2),

    ;

    private final byte type;

    InvoiceLineType(byte value) {
        this.type = value;
    }

    public byte getType() {
        return type;
    }

    public static  InvoiceLineType getByType(byte type){
        return Arrays.stream(values()).filter(v-> v.getType() == type).findFirst().orElse(InvoiceLineType.NORMAL);
    }
}
