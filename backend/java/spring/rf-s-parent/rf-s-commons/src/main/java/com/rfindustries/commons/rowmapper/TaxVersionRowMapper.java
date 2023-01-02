package com.rfindustries.commons.rowmapper;


import com.rf.collections.utils.DateUtils;
import com.rfindustries.commons.constants.EntityDefinition;
import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.dto.TaxVersionDTO;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxVersionRowMapper implements RowMapper<TaxVersionDTO> {

    @Override
    public TaxVersionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String aliasTaxTable = "TX_";
        return TaxVersionDTO.builder()
                .id(rs.getLong(EntityDefinition.ID))
                .type(TaxVersionType.findByType(rs.getByte(EntityDefinition.TYPE)))
                .startDate(DateUtils.toLocalDate(rs.getDate(EntityDefinition.START_DATE)))
                .value(rs.getBigDecimal(EntityDefinition.VALUE))
                .tax(
                        TaxDTO.builder()
                                .id(rs.getLong(aliasTaxTable + EntityDefinition.ID))
                                .code(rs.getString(aliasTaxTable + EntityDefinition.CODE))
                                .name(rs.getString(aliasTaxTable + EntityDefinition.NAME))
                                .build()
                )
                .build();
    }
}
