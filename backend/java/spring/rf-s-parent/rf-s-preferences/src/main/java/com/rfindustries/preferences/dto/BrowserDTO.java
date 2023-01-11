package com.rfindustries.preferences.dto;

import com.rfindustries.core.dto.BaseMongoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BrowserDTO extends BaseMongoDTO {
    private Long userId;
    private List<ColumnBrowserDTO> columns;
    private String key;
    private String appKey;
}
