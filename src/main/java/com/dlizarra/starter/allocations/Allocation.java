package com.dlizarra.starter.allocations;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "symbol")
@Entity
public class Allocation {

    @Id
    @Column(nullable = false, unique = true)
    private String symbol;

    @Transient
    private String symbolDescription;

    @Column(precision = 5, scale = 2)
    private BigDecimal percentage;
}
