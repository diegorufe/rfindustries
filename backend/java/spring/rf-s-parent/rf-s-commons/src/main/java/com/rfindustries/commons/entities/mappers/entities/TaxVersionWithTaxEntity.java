package com.rfindustries.commons.entities.mappers.entities;

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
public class TaxVersionWithTaxEntity {
    private TaxVersionEntity taxVersion;
    private TaxEntity tax;
}
