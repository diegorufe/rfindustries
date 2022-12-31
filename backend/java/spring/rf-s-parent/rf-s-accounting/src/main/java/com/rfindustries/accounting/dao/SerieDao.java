package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.accounting.entities.SerieEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieDao extends BaseJDBCCrudRepository<SerieEntity> {


    @Query("UPDATE RF_ACCOUNTING_SERIES " +
            "SET NUMBER = :NUMBER " +
            "WHERE ENTERPRISE_ID = :ENTERPRISE_ID " +
            "AND TYPE = :TYPE " +
            "AND CODE = :CODE " +
            "AND NUMBER < :NUMBER ")
    int incrementNumber(@Param(EntityDefinition.ENTERPRISE_ID) Long enterpriseId,
                     @Param(EntityDefinition.TYPE) Byte type,
                     @Param(EntityDefinition.CODE) String code,
                     @Param(EntityDefinition.NUMBER) Integer number);

    @Query("UPDATE RF_ACCOUNTING_SERIES " +
            "SET NUMBER = :NUMBER " +
            "WHERE ENTERPRISE_ID = :ENTERPRISE_ID " +
            "AND TYPE = :TYPE " +
            "AND CODE = :CODE " +
            "AND NUMBER = (:NUMBER - 1) ")
    int decrementNumber(@Param(EntityDefinition.ENTERPRISE_ID) Long enterpriseId,
                     @Param(EntityDefinition.TYPE) Byte type,
                     @Param(EntityDefinition.CODE) String code,
                     @Param(EntityDefinition.NUMBER) Integer number);
}
