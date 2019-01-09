package com.dlizarra.starter.allocations;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(of = "symbol")
public class AllocationDto {
    private String symbol;
    private String symbolDescription;
    private BigDecimal percentage;
}
