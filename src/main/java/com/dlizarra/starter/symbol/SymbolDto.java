package com.dlizarra.starter.symbol;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(of = "shortcut")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SymbolDto {

    private Long id;

    @Size(max = Symbol.MAX_LENGTH_SHORTCUT)
    private String shortcut;

    private String description;
}
