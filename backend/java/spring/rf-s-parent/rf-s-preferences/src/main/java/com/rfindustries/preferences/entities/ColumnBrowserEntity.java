package com.rfindustries.preferences.entities;

import com.rfindustries.coremongo.entities.BaseMongoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ColumnBrowserEntity extends BaseMongoEntity {
    private String column;
    private String title;
    private String label;
    private boolean enabled;
    private boolean sortable;
}
