package com.rfindustries.core.beans.query;

import com.rfindustries.core.constansts.query.OrderType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class OrderBy {

    private OrderType type;
    private String field;

    public OrderBy(String field, OrderType type) {
        this.field = field;
        this.type = type;
    }
}
