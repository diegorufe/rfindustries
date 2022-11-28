package com.rfindustries.core.builder.query;

import com.rf.collections.utils.StringUtils;
import com.rfindustries.core.beans.PairValue;
import com.rfindustries.core.beans.query.*;
import com.rfindustries.core.constansts.query.QueryType;

import java.util.*;

public final class QueryBuilder {

    private List<Field> fields = new ArrayList<>();

    private List<Filter<?>> filters = new ArrayList<>();
    private List<Join> joins = new ArrayList<>();

    private List<OrderBy> orders = new ArrayList<>();

    private List<GroupBy> groups = new ArrayList<>();

    private QueryType queryType;

    private QueryBuilder(QueryType queryType) {
        this.queryType = queryType;
    }

    static QueryBuilder builder() {
        return builder(QueryType.SQL);
    }

    static QueryBuilder builder(QueryType queryType) {
        return new QueryBuilder(queryType);
    }

    static QueryBuilder builderSQL() {
        return builder(QueryType.SQL);
    }

    static QueryBuilder builderMongo() {
        return builder(QueryType.MONGO);
    }

    public QueryBuilder clear() {
        this.filters.clear();
        this.joins.clear();
        this.orders.clear();
        this.groups.clear();
        return this;
    }

    public QueryBuilder select(String... fields) {
        if (fields != null) {
            Arrays.stream(fields).forEach(field -> {
                if (StringUtils.isNotBlank(field)) {
                    select(new Field(field));
                }
            });
        }
        return this;
    }

    public QueryBuilder select(Field... fields) {
        if (fields != null) {
            this.fields.addAll(Arrays.asList(fields));
        }
        return this;
    }

    public PairValue<Map<String, Object>, String> toQuery() {
        StringBuilder builder = new StringBuilder();
        Map<String, Object> mapParams = new HashMap<>();

        switch (this.queryType) {
            case SQL -> new SQLBuilder().toQuery(mapParams, builder);
            case MONGO -> new MongoBuilder().toQuery(mapParams, builder);
        }


        return new PairValue<>(mapParams, builder.toString());
    }

}
