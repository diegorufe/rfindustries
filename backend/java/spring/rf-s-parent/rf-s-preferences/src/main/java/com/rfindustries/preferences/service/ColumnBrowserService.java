package com.rfindustries.preferences.service;

import com.rfindustries.core.service.BaseCrudService;
import com.rfindustries.preferences.dao.ColumBrowserDao;
import com.rfindustries.preferences.entities.ColumnBrowserEntity;
import com.rfindustries.shared.preferences.ColumnBrowserDTO;

public interface ColumnBrowserService extends BaseCrudService<ColumBrowserDao, ColumnBrowserEntity, String, ColumnBrowserDTO> {
}
