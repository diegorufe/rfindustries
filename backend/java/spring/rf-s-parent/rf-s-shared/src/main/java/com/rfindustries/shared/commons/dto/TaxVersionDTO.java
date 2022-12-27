package com.rfindustries.shared.commons.dto;

import com.rf.collections.utils.StringUtils;
import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import com.rfindustries.shared.proto.TaxVersion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

import static com.rfindustries.shared.utils.ProtoUtils.*;
import static com.rfindustries.shared.utils.SharedMapperUtils.fromTax;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxVersionDTO extends BaseJDBCDTO {
    private LocalDate startDate;
    private BigDecimal value;
    private TaxVersionType type;
    private Long taxId;
    private TaxDTO tax;
}
