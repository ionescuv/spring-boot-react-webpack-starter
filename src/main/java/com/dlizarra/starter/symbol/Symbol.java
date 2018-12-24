package com.dlizarra.starter.symbol;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(of = "shortcut")
@NoArgsConstructor
@Entity
public class Symbol {
    static final int MAX_LENGTH_SHORTCUT = 4;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = MAX_LENGTH_SHORTCUT)
    private String shortcut;

    private String description;

    public Symbol(String shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }
}
