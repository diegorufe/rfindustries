package com.rfindustries.corejdbc.entities;

import com.rfindustries.core.entities.BaseCrudEntity;
import com.rfindustries.core.entities.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseJDBCEntity extends BaseCrudEntity<Long> {
    @Id
    private Long id;
}
