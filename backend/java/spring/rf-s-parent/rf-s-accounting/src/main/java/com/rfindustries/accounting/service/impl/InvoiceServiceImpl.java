package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.accounting.constants.CalculationInvoiceType;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        final InvoiceHeaderDTO header = dto.getHeader();
        header.setTotal(BigDecimal.ZERO);
        header.setTotalBase(BigDecimal.ZERO);
        header.setTotalTaxes(BigDecimal.ZERO);

        // delete old lines
        if (!insert) {
            this.getLineService().deleteAllByInvoiceId(baseCommonsParameters, dto.getHeader().getId());
        }

        if (CollectionUtils.isNotEmpty(dto.getLines())) {

            AtomicInteger counter = new AtomicInteger(1);
            final List<InvoiceLineDTO> lines = new ArrayList<>();

            dto.getLines().forEach(line -> {
                line.setNumber(counter.getAndIncrement());

                this.getLineService().calculateTotal(baseCommonsParameters, line);

                header.setTotalBase(header.getTotalBase().add(line.getAmount()));
                header.setTotalTaxes(header.getTotalTaxes().add(line.getTotal().subtract(line.getAmount())));
                header.setTotal(header.getTotal().add(line.getTotal()));
            });

            dto.setLines(lines);
        }

        // Update totals
        this.getHeaderService().updateTotals(header);
    }

    @Override
    public InvoiceDTO goAdd(BaseCommonsParameters baseCommonsParameters) {
        InvoiceDTO dto = super.goAdd(baseCommonsParameters);
        dto.getHeader().setDateTime(LocalDateTime.now());

        return dto;
    }

    @Override
    public InvoiceDTO calculateInvoice(BaseCommonsParameters baseCommonsParameters, CalculationInvoiceType calculationInvoiceType, InvoiceDTO dto) {

        switch (calculationInvoiceType) {
            case CALCULATE_TOTAL_LINE -> this.calculateTotalLine(baseCommonsParameters, dto);
            case CALCULATE_TOTAL_INVOICE -> this.calculateTotalInvoice(baseCommonsParameters, dto);
        }

        return dto;
    }

    private void calculateTotalLine(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto) {
        if (dto.getOptions() != null && dto.getOptions().getLineIndex() != null && dto.getOptions().getLineIndex().compareTo(0) >= 0 && CollectionUtils.isNotEmpty(dto.getLines())) {
            this.getLineService().calculateTotal(baseCommonsParameters, dto.getLines().get(dto.getOptions().getLineIndex()));
        }

        this.calculateTotalInvoice(baseCommonsParameters, dto);
    }

    private void calculateTotalInvoice(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto) {

        final InvoiceHeaderDTO header = dto.getHeader();
        header.setTotal(BigDecimal.ZERO);
        header.setTotalBase(BigDecimal.ZERO);
        header.setTotalTaxes(BigDecimal.ZERO);

        if (CollectionUtils.isNotEmpty(dto.getLines())) {
            dto.getLines().forEach(line -> {
                header.setTotalBase(header.getTotalBase().add(line.getAmount()));
                header.setTotalTaxes(header.getTotalTaxes().add(line.getTotal().subtract(line.getAmount())));
                header.setTotal(header.getTotal().add(line.getTotal()));
            });
        }
    }
}
