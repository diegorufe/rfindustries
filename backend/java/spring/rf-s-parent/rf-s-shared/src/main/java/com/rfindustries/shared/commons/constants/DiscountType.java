package com.rfindustries.shared.commons.constants;

public enum DiscountType {

    RATE((byte) 1),

    AMOUNT((byte) 2),

    ;

    private byte type;

    DiscountType(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }
}
