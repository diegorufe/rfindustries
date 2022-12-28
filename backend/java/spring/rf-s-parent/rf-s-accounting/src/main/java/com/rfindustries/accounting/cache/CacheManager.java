package com.rfindustries.accounting.cache;

import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheManager {

    private ConcurrentHashMap<Long, ConcurrentHashMap<Long, TaxVersionDTO>> taxVersions = new ConcurrentHashMap<>();


    public Optional<TaxVersionDTO> findTaxVersion(BaseCommonsParameters baseCommonsParameters, Long id) {
        TaxVersionDTO dto = null;

        if (baseCommonsParameters != null && baseCommonsParameters.getBusinessCustomerId() != null) {
            ConcurrentHashMap<Long, TaxVersionDTO> cacheTaxVersions = taxVersions.getOrDefault(baseCommonsParameters.getBusinessCustomerId(), null);

            if (id != null && cacheTaxVersions != null && cacheTaxVersions.containsKey(id)) {
                dto = cacheTaxVersions.get(id);
            }
        }

        return Optional.ofNullable(dto);
    }

    public TaxVersionDTO putTaxVersion(BaseCommonsParameters baseCommonsParameters, TaxVersionDTO dto) {
        if (baseCommonsParameters != null && baseCommonsParameters.getBusinessCustomerId() != null && dto != null) {
            ConcurrentHashMap<Long, TaxVersionDTO> cacheTaxVersions = taxVersions.getOrDefault(baseCommonsParameters.getBusinessCustomerId(), null);
            boolean addMap = false;

            if(cacheTaxVersions == null){
                cacheTaxVersions = new ConcurrentHashMap<>();
                addMap = true;
            }
            cacheTaxVersions.put(dto.getId(), dto);

            if(addMap){
                this.taxVersions.put((Long) baseCommonsParameters.getBusinessCustomerId(), cacheTaxVersions);
            }
        }
        return dto;
    }

    public void clearTaxVersions() {
        this.taxVersions.clear();
    }
}
