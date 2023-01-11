package com.rfindustries.preferences.service.impl;

import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.coremongo.service.BaseReactiveCrudServiceImpl;
import com.rfindustries.preferences.dao.BrowserDao;
import com.rfindustries.preferences.dto.BrowserDTO;
import com.rfindustries.preferences.entities.BrowserEntity;
import com.rfindustries.preferences.service.BrowserService;
import com.rfindustries.preferences.utils.PreferenceMapperUtils;
import org.springframework.stereotype.Service;

@Service
public class BrowserServiceImpl extends BaseReactiveCrudServiceImpl<BrowserDao, BrowserEntity, String, BrowserDTO> implements BrowserService {

    @Override
    public BrowserEntity toEntity(BaseCommonsParameters baseCommonsParameters, BrowserDTO dto) {
        return PreferenceMapperUtils.toBrowserEntity(dto);
    }

    @Override
    public BrowserDTO toDTO(BaseCommonsParameters baseCommonsParameters, BrowserEntity entity) {
        return PreferenceMapperUtils.toBrowserDTO(entity);
    }

    @Override
    public BrowserDTO instanceDTO() {
        return BrowserDTO.builder().build();
    }
}
