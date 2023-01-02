package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.accounting.dto.ConfigurationDTO;
import com.rfindustries.accounting.entities.ConfigurationEntity;
import com.rfindustries.accounting.rowmapper.ConfigurationRowMapper;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationDao extends BaseJDBCCrudRepository<ConfigurationEntity> {

    @Query(value = "SELECT c.*, " +
            "acc.id ACC_ID, acc.CODE ACC_CODE, acc.NAME ACC_NAME, " +
            "acy.id ACY_ID, acy.CODE ACY_CODE, acy.NAME ACY_NAME, acy.START_DATE ACY_START_DATE, acy.END_DATE ACY_END_DATE " +
            "FROM RF_ACCOUNTING_CONFIGURATIONS c" +
            "LEFT JOIN RF_ACCOUNTING_ACCOUNTING acc ON c.ACCOUNTING_ID = acc.ID " +
            "LEFT JOIN RF_ACCOUNTING_ACCOUNTING_YEARS acy ON c.ACCOUNTING_YEAR_ID = acy.ID " +
            "WHERE ENTERPRISE_ID = :ENTERPRISE_ID", rowMapperClass = ConfigurationRowMapper.class)
    ConfigurationDTO findByEnterpriseId(@Param(EntityDefinition.ENTERPRISE_ID) Long enterpriseId);
}
