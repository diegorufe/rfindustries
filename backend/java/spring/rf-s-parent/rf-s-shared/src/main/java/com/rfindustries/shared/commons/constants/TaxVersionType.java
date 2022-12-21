package com.rfindustries.shared.commons.constants;

import java.util.Arrays;

public enum TaxVersionType {

    RATE((byte) 0),

    AMOUNT((byte) 1),

    ;

    private byte type;

    TaxVersionType(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }

    public static TaxVersionType findByType(int type){
        return findByType((byte) type);
    }

    public static TaxVersionType findByType(byte type){
        return Arrays.stream(TaxVersionType.values()).filter(taxVersionType -> taxVersionType.getType() == type).findFirst().orElse(RATE);
    }
}
