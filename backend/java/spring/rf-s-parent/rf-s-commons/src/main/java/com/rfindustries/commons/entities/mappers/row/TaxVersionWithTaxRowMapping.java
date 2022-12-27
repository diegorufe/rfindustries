package com.rfindustries.commons.entities.mappers.row;


import com.rfindustries.commons.constants.EntityDefinition;
import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.entities.mappers.entities.TaxVersionWithTaxEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxVersionWithTaxRowMapping implements RowMapper<TaxVersionWithTaxEntity> {

    private final String ALIAS_TAX_TABLE = "tx_";

    @Override
    public TaxVersionWithTaxEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TaxVersionWithTaxEntity.builder()
                .taxVersion(TaxVersionEntity.builder()
                        .id(rs.getLong(EntityDefinition.ID))
                        .type(rs.getByte(EntityDefinition.TYPE))
                        .value(rs.getBigDecimal(EntityDefinition.VALUE))
                        .build())
                .tax(
                        TaxEntity.builder()
                                .id(rs.getLong(ALIAS_TAX_TABLE + EntityDefinition.ID))
                                .code(rs.getString(ALIAS_TAX_TABLE + EntityDefinition.CODE))
                                .name(rs.getString(ALIAS_TAX_TABLE + EntityDefinition.NAME))
                                .build()
                )
                .build();
    }
}
