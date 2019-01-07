package com.dlizarra.starter.holdings;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "symbol")
public class HoldingDto {
    private String symbol;
    private String symbolDescription;
    private int amount;
}
