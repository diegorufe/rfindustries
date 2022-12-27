package com.rfindustries.commons.entities.mappings.entitymappings;

import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.commons.entities.TaxVersionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxVersionWithTaxMapping {
    private TaxVersionEntity taxVersion;
    private TaxEntity tax;
}
