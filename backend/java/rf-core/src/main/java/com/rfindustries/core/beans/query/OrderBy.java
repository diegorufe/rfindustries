package com.rfindustries.core.beans.query;

import com.rfindustries.core.constansts.query.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class OrderBy {

    private OrderType type;
    private String field;

    public OrderBy(String field, OrderType type) {
        this.field = field;
        this.type = type;
    }
}
