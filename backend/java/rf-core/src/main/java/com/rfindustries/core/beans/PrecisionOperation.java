package com.rfindustries.core.beans;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PrecisionOperation {
    @Builder.Default
    private int total = 2;

    @Builder.Default
    private int amount = 2;

    @Builder.Default
    private int prices = 6;
}
