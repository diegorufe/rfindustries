package com.rfindustries.core.builder.query;

import java.util.Map;

public interface TransformQueryBuilder {
    void toQuery(Map<String, Object> mapParams, StringBuilder builder);
}
