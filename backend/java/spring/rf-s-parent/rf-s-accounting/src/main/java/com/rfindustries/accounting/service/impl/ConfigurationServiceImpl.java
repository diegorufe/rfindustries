package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.cache.CacheManager;
import com.rfindustries.accounting.dao.ConfigurationDao;
import com.rfindustries.accounting.dto.ConfigurationDTO;
import com.rfindustries.accounting.entities.ConfigurationEntity;
import com.rfindustries.accounting.service.ConfigurationService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigurationServiceImpl extends BaseTransactionalCrudServiceImpl<ConfigurationDao, ConfigurationEntity, Long, ConfigurationDTO>
        implements ConfigurationService {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public ConfigurationEntity toEntity(BaseCommonsParameters baseCommonsParameters, ConfigurationDTO dto) {
        return AccountingMapperUtils.toConfigurationEntity(dto);
    }

    @Override
    public ConfigurationDTO toDTO(BaseCommonsParameters baseCommonsParameters, ConfigurationEntity entity) {
        return AccountingMapperUtils.toConfigurationDTO(entity);
    }

    @Override
    public ConfigurationDTO instanceDTO() {
        return ConfigurationDTO.builder().build();
    }

    @Override
    public ConfigurationDTO findByEnterpriseIdCached(BaseCommonsParameters baseCommonsParameters) {
        ConfigurationDTO result = null;

        if (baseCommonsParameters != null && baseCommonsParameters.getEnterpriseId() != null) {
            Optional<ConfigurationDTO> op = this.cacheManager.findConfigurationDTO(baseCommonsParameters, baseCommonsParameters.getEnterpriseIdCastToDesire());

            if (op.isPresent()) {
                result = op.get();
            } else {
                result = this.getDao().findByEnterpriseId(baseCommonsParameters.getEnterpriseIdCastToDesire());
                if (result != null) {
                    this.cacheManager.putConfigurationDTO(baseCommonsParameters, result, baseCommonsParameters.getEnterpriseIdCastToDesire());
                }
            }
        }

        return result;
    }
}
