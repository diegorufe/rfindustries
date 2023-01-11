package com.rfindustries.shared.preferences;

import com.rfindustries.core.dto.BaseMongoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ColumnDTO extends BaseMongoDTO {
    private String column;
    private String title;
    private String label;
    private boolean enabled;
    private boolean sortable;
    private Long userId;
    private String key;
    private String appKey;
}
