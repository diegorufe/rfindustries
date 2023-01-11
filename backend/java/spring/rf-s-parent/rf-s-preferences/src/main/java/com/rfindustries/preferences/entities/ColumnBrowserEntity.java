package com.rfindustries.preferences.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ColumnBrowserEntity {
    private String column;
    private String title;
    private String label;
    private boolean enabled;
    private boolean sortable;
}
