package com.rfindustries.accounting.cache;

import com.rfindustries.accounting.dto.ConfigurationDTO;
import com.rfindustries.core.beans.cache.CacheValue;
import com.rfindustries.core.constansts.SchedulingConstants;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import org.checkerframework.checker.units.qual.C;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static com.rfindustries.core.utils.CacheUtils.*;

@Component
public class CacheManager {

    private Map<Long, Map<Long, CacheValue<TaxVersionDTO>>> taxVersions = new ConcurrentHashMap<>();

    private Map<Long, Map<Long, CacheValue<ConfigurationDTO>>> configurations = new ConcurrentHashMap<>();


    public Optional<TaxVersionDTO> findTaxVersion(BaseCommonsParameters baseCommonsParameters, Long id) {
        return findCacheValueBusinessCustomer(baseCommonsParameters, this.taxVersions, id);
    }

    public TaxVersionDTO putTaxVersion(BaseCommonsParameters baseCommonsParameters, TaxVersionDTO dto) {
        return putCacheValueBusinessCustomer(baseCommonsParameters, this.taxVersions, dto, dto.getId());
    }

    public Optional<ConfigurationDTO> findConfigurationDTO(BaseCommonsParameters baseCommonsParameters, Long enterpriseId) {
        return findCacheValueBusinessCustomer(baseCommonsParameters, this.configurations, enterpriseId);
    }

    public ConfigurationDTO putConfigurationDTO(BaseCommonsParameters baseCommonsParameters, ConfigurationDTO dto, Long enterpriseId) {
        return putCacheValueBusinessCustomer(baseCommonsParameters, this.configurations, dto, enterpriseId);
    }

    @Scheduled(cron = SchedulingConstants.SPRING_CRON_JOB_CLEAR_CACHE)
    public void clearCache() {
        this.clearCacheTaxVersions();
        this.clearCacheConfigurations();
    }

    private void clearCacheTaxVersions() {
        clearValuesCache(this.taxVersions);
    }

    private void clearCacheConfigurations() {
        clearValuesCache(this.configurations);
    }


}
