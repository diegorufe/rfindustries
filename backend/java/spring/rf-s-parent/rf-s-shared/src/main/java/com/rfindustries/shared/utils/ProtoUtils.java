package com.rfindustries.shared.utils;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import com.google.type.Decimal;
import com.google.type.Money;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutionException;

public final class ProtoUtils {

    private ProtoUtils() {
        // NOT IMPLEMENTED
    }

    public static Timestamp toGoogleTimestampUTC(final LocalDateTime localDateTime) {
        return Timestamp.newBuilder()
                .setSeconds(localDateTime.toEpochSecond(ZoneOffset.UTC))
                .setNanos(localDateTime.getNano())
                .build();
    }

    public static LocalDateTime fromGoogleTimestampUTCToLocalDateTime(final Timestamp googleTimestamp) {
        return googleTimestamp == null ? null : Instant.ofEpochSecond(googleTimestamp.getSeconds(), googleTimestamp.getNanos())
                .atOffset(ZoneOffset.UTC)
                .toLocalDateTime();
    }

    public static LocalDate fromGoogleTimestampUTCToLocalDate(final Timestamp googleTimestamp) {
        LocalDateTime localDateTime = fromGoogleTimestampUTCToLocalDateTime(googleTimestamp);
        return localDateTime == null ? null : localDateTime.toLocalDate();
    }

    public static Date toGoogleDate(final LocalDate localDate) {
        return localDate == null ? null : Date.newBuilder()
                .setYear(localDate.getYear())
                .setMonth(localDate.getMonth().getValue())
                .setDay(localDate.getDayOfMonth())
                .build();
    }

    public static LocalDate fromGoogleDate(final Date googleDate) {
        return googleDate == null ? null : LocalDate.of(googleDate.getYear(), googleDate.getMonth(), googleDate.getDay());
    }

    public static Money toGoogleMoney(final BigDecimal decimal) {
        return Money.newBuilder()
                .setCurrencyCode("USD")
                .setUnits(decimal.longValue())
                .setNanos(decimal.remainder(BigDecimal.ONE).movePointRight(decimal.scale()).intValue())
                .build();
    }

    public static BigDecimal fromGoogleMoney(final Money googleMoney) {
        return new BigDecimal(googleMoney.getUnits())
                .add(new BigDecimal(googleMoney.getNanos(), new MathContext(9)));
    }

    public static BigDecimal fromGoogleDecimal(final Decimal decimal) {
        return decimal == null ? null : new BigDecimal(decimal.getValue());
    }

    public static <T> T get(ListenableFuture<T> listenableFuture){
        try {
            return listenableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static Int64Value toInt64Value(Long value){
        return value == null ? null : Int64Value.of(value);
    }

    public static  Long getLongValue(Int64Value value){
        return value == null ? null : value.getValue();
    }
}
