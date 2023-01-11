package com.rfindustries.preferences.dto;

import com.rfindustries.core.dto.BaseMongoDTO;
import com.rfindustries.shared.preferences.ColumnDTO;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnBrowserDTO{
    private String column;
    private String title;
    private String label;
    private boolean enabled;
    private boolean sortable;
}
