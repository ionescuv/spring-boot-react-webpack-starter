package com.dlizarra.starter.holdings;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "symbol")
@Entity
public class Holding {

    @Id
    @Column(nullable = false, unique = true)
    private String symbol;

    @Transient
    private String symbolDescription;

    private int amount;
}
