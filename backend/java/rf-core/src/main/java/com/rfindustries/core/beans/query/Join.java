package com.rfindustries.core.beans.query;

import com.rfindustries.core.constansts.query.JoinType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
public final class Join {

    private JoinType type;
    private String condition;
    private Map<String, Object> params;

    public Join(JoinType type, String condition) {
        this(type, condition, null);
    }

    public Join(JoinType type, String condition, Map<String, Object> params) {
        this.type = type;
        this.condition = condition;
        this.params = params;
    }
}
