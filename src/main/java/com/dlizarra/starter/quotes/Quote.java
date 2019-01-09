package com.dlizarra.starter.quotes;

import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@ToString
public class Quote {

    private String symbol;

    @Transient
    private String symbolDescription;

    private BigDecimal price;

    private LocalDate tradingDay;

}
