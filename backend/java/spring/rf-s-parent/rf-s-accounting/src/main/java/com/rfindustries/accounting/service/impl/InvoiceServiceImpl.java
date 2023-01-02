package com.rfindustries.accounting.service.impl;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.accounting.constants.CalculationInvoiceType;
import com.rfindustries.accounting.dao.InvoiceHeaderDao;
import com.rfindustries.accounting.dao.InvoiceLineDao;
import com.rfindustries.accounting.dto.*;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.accounting.service.ConfigurationService;
import com.rfindustries.accounting.service.InvoiceHeaderService;
import com.rfindustries.accounting.service.InvoiceLineService;
import com.rfindustries.accounting.service.InvoiceService;
import com.rfindustries.core.beans.ResponseMethod;
import com.rfindustries.core.features.BaseCommonsParameters;
import com.rfindustries.core.features.CalculationType;
import com.rfindustries.corejdbc.service.BaseTransactionalCrudHeaderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InvoiceServiceImpl
        extends BaseTransactionalCrudHeaderLineServiceImpl<
        InvoiceDTO,
        InvoiceHeaderService, InvoiceHeaderDao, InvoiceHeaderEntity, Long, InvoiceHeaderDTO,
        InvoiceLineService, InvoiceLineDao, InvoiceLineEntity, Long, InvoiceLineDTO,
        OptionInvoiceDTO
        > implements InvoiceService {

    @Autowired
    private ConfigurationService configurationService;

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
    public ResponseMethod<InvoiceDTO> upsert(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto, boolean insert) {
        ResponseMethod<InvoiceDTO> responseMethod = ResponseMethod.<InvoiceDTO>builder().build();
        // TODO check validations
        this.upsertHeader(baseCommonsParameters, responseMethod, dto, insert);
        this.upsertLines(baseCommonsParameters, responseMethod, dto, insert);

        responseMethod.setData(dto);

        return responseMethod;
    }

    private void upsertHeader(BaseCommonsParameters baseCommonsParameters, ResponseMethod<InvoiceDTO> responseMethod, InvoiceDTO dto, boolean insert) {
        ResponseMethod<InvoiceHeaderDTO> responseHeader = insert ? this.getHeaderService().insert(baseCommonsParameters, dto.getHeader()) : this.getHeaderService().update(baseCommonsParameters, dto.getHeader());
        dto.setHeader(responseHeader.getData());
        this.mergeMessagesResponseMethod(responseMethod, responseHeader);
        // TODO remove seats
    }

    private void upsertLines(BaseCommonsParameters baseCommonsParameters, ResponseMethod<InvoiceDTO> responseMethod, InvoiceDTO dto, boolean insert) {
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

            dto.getLines().forEach(line -> {
                line.setNumber(counter.getAndIncrement());
                line.setDateTime(header.getDateTime());

                this.getLineService().calculateTotal(baseCommonsParameters, line);

                header.setTotalBase(header.getTotalBase().add(line.getAmount()));
                header.setTotalTaxes(header.getTotalTaxes().add(line.getTotal().subtract(line.getAmount())));
                header.setTotal(header.getTotal().add(line.getTotal()));
            });

            ResponseMethod<List<InvoiceLineDTO>> responseLines = this.getLineService().insertAll(baseCommonsParameters, dto.getLines());
            this.mergeMessagesResponseMethod(responseMethod, responseLines);

            dto.setLines(responseLines.getData());
        }

        // Update totals
        this.getHeaderService().updateTotals(header);
    }

    @Override
    public ResponseMethod<InvoiceDTO> goAdd(BaseCommonsParameters baseCommonsParameters) {
        ResponseMethod<InvoiceDTO> responseMethod = super.goAdd(baseCommonsParameters);
        InvoiceHeaderDTO header = responseMethod.getData().getHeader();
        header.setDateTime(LocalDateTime.now());

        ConfigurationDTO configuration = this.configurationService.findByEnterpriseIdCached(baseCommonsParameters);

        if (configuration != null) {
            header.setAccounting(configuration.getAccounting());
            header.setAccountingYear(configuration.getAccountingYear());
        }


        return responseMethod;
    }

    @Override
    public ResponseMethod<InvoiceDTO> calculate(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto) {
        Set<CalculationType> calculationTypes = dto.getOptions() == null ? null : dto.getOptions().getCalculationTypes();
        ResponseMethod<InvoiceDTO> responseMethod = ResponseMethod.<InvoiceDTO>builder().data(dto).build();

        if (calculationTypes != null) {
            calculationTypes.forEach(type -> {
                switch ((CalculationInvoiceType) type) {
                    case ADD_LINE -> this.addLine(baseCommonsParameters, dto);
                    case CALCULATE_TOTAL_LINE -> this.calculateTotalLine(baseCommonsParameters, dto);
                    case CALCULATE_TOTAL_INVOICE -> this.calculateTotalInvoice(baseCommonsParameters, dto);
                    case FIND_TAX_VERSION -> this.findTaxVersion(baseCommonsParameters, dto);
                    case RECALCULATE_LINES -> this.recalculateLines(baseCommonsParameters, dto);
                }
            });
        }

        return responseMethod;
    }

    private void calculateTotalLine(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto) {
        if (dto.getOptions() != null && dto.getOptions().getLineIndex() != null && dto.getOptions().getLineIndex().compareTo(0) >= 0 && CollectionUtils.isNotEmpty(dto.getLines())) {
            this.getLineService().calculateTotal(baseCommonsParameters, dto.getLines().get(dto.getOptions().getLineIndex()));
        }
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

    private void findTaxVersion(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto) {
        if (dto.getOptions() != null && dto.getOptions().getLineIndex() != null && dto.getOptions().getLineIndex().compareTo(0) >= 0 && CollectionUtils.isNotEmpty(dto.getLines())) {
            this.getLineService().recalculate(baseCommonsParameters, dto.getLines().get(dto.getOptions().getLineIndex()));
        }
    }

    private void recalculateLines(BaseCommonsParameters baseCommonsParameters, InvoiceDTO dto) {
        if (CollectionUtils.isNotEmpty(dto.getLines())) {
            dto.getLines().forEach(line -> {
                line.setDateTime(dto.getHeader().getDateTime());
                this.getLineService().recalculate(baseCommonsParameters, line);
            });
        }
    }
}
