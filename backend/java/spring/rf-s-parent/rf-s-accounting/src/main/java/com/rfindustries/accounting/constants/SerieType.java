package com.rfindustries.accounting.constants;

import java.util.Arrays;

public enum SerieType {
    PURCHASE((byte) 1),
    SALE((byte) 2),
    INVESTMENT((byte) 3),

    ;

    private final byte type;

    SerieType(byte value) {
        this.type = value;
    }

    public byte getType() {
        return type;
    }

    public static SerieType getByType(byte type) {
        return Arrays.stream(values()).filter(v -> v.getType() == type).findFirst().orElse(SerieType.PURCHASE);
    }
}
