package com.rfindustries.accounting.service.impl;

import com.rfindustries.accounting.dao.LedgerAccountDao;
import com.rfindustries.accounting.dto.LedgerAccountDTO;
import com.rfindustries.accounting.entities.LedgerAccountEntity;
import com.rfindustries.accounting.service.LedgerAccountService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LedgerAccountServiceImpl extends BaseTransactionalCrudServiceImpl<LedgerAccountDao, LedgerAccountEntity, Long, LedgerAccountDTO>
        implements LedgerAccountService {

    @Override
    public LedgerAccountEntity toEntity(BaseCommonsParameters baseCommonsParameters, LedgerAccountDTO dto) {
        return AccountingMapperUtils.toLedgerAccountEntity(dto);
    }

    @Override
    public LedgerAccountDTO toDTO(BaseCommonsParameters baseCommonsParameters, LedgerAccountEntity entity) {
        return AccountingMapperUtils.toLedgerAccountDTO(entity);
    }

    @Override
    public LedgerAccountDTO instanceDTO() {
        return LedgerAccountDTO.builder().build();
    }
}
