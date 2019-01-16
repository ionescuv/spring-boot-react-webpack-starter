package com.dlizarra.starter.quotes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class QuoteDto {
    private String symbol;
    private String symbolDescription;
    private BigDecimal price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String tradingDay;

}
