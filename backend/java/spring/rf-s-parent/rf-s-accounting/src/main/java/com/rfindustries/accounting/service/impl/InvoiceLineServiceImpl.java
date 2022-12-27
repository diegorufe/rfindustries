package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.accounting.utils.AccountingMapperUtils;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceLineServiceImpl extends BaseTransactionalCrudServiceImpl<InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO>
        implements InvoiceLineService {

    @Override
    public InvoiceLineEntity toEntity(InvoiceLineDTO dto) {
        return AccountingMapperUtils.toInvoiceLineEntity(dto);
    }

    @Override
    public InvoiceLineDTO toDTO(InvoiceLineEntity entity) {
        return AccountingMapperUtils.toInvoiceLineDTO(entity);
    }

    @Override
    public InvoiceLineDTO instanceDTO() {
        return InvoiceLineDTO.builder().build();
    }

    @Override
    public List<InvoiceLineDTO> findAllByInvoiceId(Long invoiceId) {
        List<InvoiceLineDTO> result = new ArrayList<>();

        if (invoiceId != null) {
            List<InvoiceLineEntity> entities = this.getDao().findAllByInvoiceId(invoiceId);

            if (CollectionUtils.isNotEmpty(entities)) {
                result = entities.stream().map(this::toDTO).toList();
            }
        }

        // TODO find tax versions dtos

        return result;
    }

    @Override
    public <HEADER_PK> List<InvoiceLineDTO> findByHeaderPk(HEADER_PK headerPk) {
        return this.findAllByInvoiceId((Long) headerPk);
    }

    @Transactional
    @Override
    public <HEADER_PK> long deleteByHeaderPk(HEADER_PK headerPk) {
        return this.deleteAllByInvoiceId((Long) headerPk);
    }

    @Transactional
    @Override
    public long deleteAllByInvoiceId(Long invoiceId) {
        return this.getDao().deleteAllByInvoiceId(invoiceId);
    }
}
