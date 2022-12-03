package com.rfindustries.core.beans.query;

import com.rfindustries.core.constansts.query.FilterOperator;
import com.rfindustries.core.constansts.query.FilterType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Filter<T> {

    private FilterType type;
    private FilterOperator operator;

    private String field;

    private T value;

    private int openBrackets;

    private int closeBrackets;

    public Filter(String field, T value) {
        this(field, FilterType.EQUAL, FilterOperator.AND, value);
    }

    public Filter(String field, FilterType type, T value) {
        this(field, type, FilterOperator.AND, value);
    }

    public Filter(String field, FilterType type, FilterOperator operator, T value) {
        this(field, type, operator, value, 1, 1);
    }

    public Filter(String field, FilterType type, FilterOperator operator, T value, int openBrackets, int closeBrackets) {
        this.field = field;
        this.type = type;
        this.operator = operator;
        this.value = value;
        this.openBrackets = openBrackets;
        this.closeBrackets = closeBrackets;
    }

}
