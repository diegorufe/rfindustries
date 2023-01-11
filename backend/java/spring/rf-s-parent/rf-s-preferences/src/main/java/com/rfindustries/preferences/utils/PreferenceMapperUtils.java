package com.rfindustries.preferences.utils;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.preferences.dto.BrowserDTO;
import com.rfindustries.preferences.dto.ColumnBrowserDTO;
import com.rfindustries.preferences.entities.BrowserEntity;
import com.rfindustries.preferences.entities.ColumnBrowserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class PreferenceMapperUtils {

    private PreferenceMapperUtils(){
        // NOT IMPLEMENTED
    }

    public static BrowserEntity toBrowserEntity(BrowserDTO dto) {
        return BrowserEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .userId(dto.getUserId())
                .columns(toColumnBrowserEntities(dto.getColumns()))
                .key(dto.getKey())
                .appKey(dto.getAppKey())
                .build();
    }

    public static BrowserDTO toBrowserDTO(BrowserEntity entity) {
        return BrowserDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .userId(entity.getUserId())
                .columns(toColumnBrowserDTOs(entity.getColumns()))
                .key(entity.getKey())
                .appKey(entity.getAppKey())
                .build();
    }

    public static ColumnBrowserEntity toColumnBrowserEntity(ColumnBrowserDTO dto) {
        return ColumnBrowserEntity.builder()
                .column(dto.getColumn())
                .title(dto.getTitle())
                .label(dto.getLabel())
                .sortable(dto.isSortable())
                .enabled(dto.isEnabled())
                .build();
    }

    public static List<ColumnBrowserEntity> toColumnBrowserEntities(List<ColumnBrowserDTO> dtos){
        List<ColumnBrowserEntity> result = new ArrayList<>();

        if(CollectionUtils.isNotEmpty(dtos)){
            result = dtos.stream().map(PreferenceMapperUtils::toColumnBrowserEntity).collect(Collectors.toList());
        }

        return result;
    }

    public static ColumnBrowserDTO toColumnBrowserDTO(ColumnBrowserEntity entity) {
        return ColumnBrowserDTO.builder()
                .column(entity.getColumn())
                .title(entity.getTitle())
                .label(entity.getLabel())
                .sortable(entity.isSortable())
                .enabled(entity.isEnabled())
                .build();
    }

    public static List<ColumnBrowserDTO> toColumnBrowserDTOs(List<ColumnBrowserEntity> entities){
        List<ColumnBrowserDTO> result = new ArrayList<>();

        if(CollectionUtils.isNotEmpty(entities)){
            result = entities.stream().map(PreferenceMapperUtils::toColumnBrowserDTO).collect(Collectors.toList());
        }

        return result;
    }
}
