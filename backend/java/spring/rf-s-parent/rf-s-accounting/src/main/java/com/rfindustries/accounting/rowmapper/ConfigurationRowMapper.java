package com.rfindustries.accounting.rowmapper;


import com.rf.collections.utils.DateUtils;
import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.accounting.dto.AccountingDTO;
import com.rfindustries.accounting.dto.AccountingYearDTO;
import com.rfindustries.accounting.dto.ConfigurationDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigurationRowMapper implements RowMapper<ConfigurationDTO> {

    @Override
    public ConfigurationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String aliasTaxTableAccountings = "ACC_";
        final String aliasTaxTableAccountingYears = "ACY_";
        return ConfigurationDTO.builder()
                .id(rs.getLong(EntityDefinition.ID))
                .accounting(
                        AccountingDTO.builder()
                                .id(rs.getLong(aliasTaxTableAccountings + EntityDefinition.ID))
                                .code(rs.getString(aliasTaxTableAccountings + EntityDefinition.CODE))
                                .name(rs.getString(aliasTaxTableAccountings + EntityDefinition.NAME))
                                .build()
                )
                .accountingYear(
                        AccountingYearDTO.builder()
                                .id(rs.getLong(aliasTaxTableAccountingYears + EntityDefinition.ID))
                                .code(rs.getString(aliasTaxTableAccountingYears + EntityDefinition.CODE))
                                .name(rs.getString(aliasTaxTableAccountingYears + EntityDefinition.NAME))
                                .startDate(DateUtils.toLocalDate(rs.getDate(aliasTaxTableAccountingYears + EntityDefinition.START_DATE)))
                                .endDate(DateUtils.toLocalDate(rs.getDate(aliasTaxTableAccountingYears + EntityDefinition.END_DATE)))
                                .build()
                )
                .build();
    }
}
