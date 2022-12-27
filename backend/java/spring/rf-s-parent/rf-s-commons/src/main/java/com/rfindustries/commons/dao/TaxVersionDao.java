package com.rfindustries.commons.dao;

import com.rfindustries.commons.constants.EntityDefinition;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.entities.mappings.entitymappings.TaxVersionWithTaxMapping;
import com.rfindustries.commons.entities.mappings.rowmappings.TaxVersionWithTaxRowMapping;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TaxVersionDao extends BaseJDBCCrudRepository<TaxVersionEntity> {

    @Query(
            value = "SELECT tv.*, tx.ID TX_ID, tx.CODE TX_CODE, tx.NAME TX_NAME FROM RF_COMMONS_TAXES_VERSIONS tv " +
                    "INNER JOIN RF_COMMONS_TAXES " +
                    "tx ON tv.TAX_ID = tx.ID " +
                    "WHERE " +
                    "tv.TAX_ID = :TAX_ID " +
                    "AND " +
                    "tv.START_DATE <= :START_DATE ORDER BY tv.START_DATE DESC LIMIT 1",
            rowMapperClass = TaxVersionWithTaxRowMapping.class)
    TaxVersionWithTaxMapping findTaxVersionByTaxIdAndDate(@Param(EntityDefinition.TAX_ID) Long taxId, @Param(EntityDefinition.START_DATE) LocalDate startDate);
}
