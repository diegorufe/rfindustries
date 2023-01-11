package com.rfindustries.preferences.entities;

import com.rfindustries.coremongo.entities.BaseMongoEntity;
import com.rfindustries.preferences.dto.ColumnBrowserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BrowserEntity extends BaseMongoEntity {
    private Long userId;
    private List<ColumnBrowserEntity> columns;
    private String key;
    private String appKey;
}
