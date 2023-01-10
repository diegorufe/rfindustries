package com.rfindustries.coremongo.entities;

import com.rfindustries.core.entities.BaseCrudEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseMongoEntity extends BaseCrudEntity<String> {
    @Id
    private String id;
}
