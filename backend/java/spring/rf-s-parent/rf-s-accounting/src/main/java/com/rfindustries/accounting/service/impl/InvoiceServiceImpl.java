package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.InvoiceDTO;
import com.rfindustries.accounting.dto.InvoiceHeaderDTO;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.dto.OptionInvoiceDTO;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.InvoiceHeaderService;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.accounting.service.InvoiceService;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudHeaderLineServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InvoiceServiceImpl
        extends BaseTransactionalCrudHeaderLineServiceImpl<
        InvoiceDTO,
        InvoiceHeaderService, InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO,
        InvoiceLineService, InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO,
        OptionInvoiceDTO
        > implements InvoiceService {

    @Override
    public InvoiceDTO instanceDTO() {
        return InvoiceDTO.builder()
                .header(this.getHeaderService().instanceDTO())
                .lines(new ArrayList<>())
                .options(OptionInvoiceDTO.builder().build())
                .build();
    }

    @Transactional
    @Override
    public InvoiceDTO upsert(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto, boolean insert) {
        // TODO check validations
        this.upsertHeader(baseCommonsParameters, dto, insert);
        this.upsertLines(baseCommonsParameters, dto, insert);

        return dto;
    }

    private void upsertHeader(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto, boolean insert) {
        dto.setHeader(insert ? this.getHeaderService().insert(baseCommonsParameters, dto.getHeader()) : this.getHeaderService().update(baseCommonsParameters, dto.getHeader()));
        // TODO remove seats
    }

    private void upsertLines(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto, boolean insert) {
        // delete old lines
        if (!insert) {
            this.getLineService().deleteAllByInvoiceId(dto.getHeader().getId());
        }

        if (CollectionUtils.isNotEmpty(dto.getLines())) {
            AtomicInteger counter = new AtomicInteger(1);
            final List<InvoiceLineDTO> lines = new ArrayList<>();

            dto.getLines().forEach(line -> {
                line.setNumber(counter.getAndIncrement());

                // TODO calculate amount
            });

            dto.setLines(lines);
        }
    }
}
