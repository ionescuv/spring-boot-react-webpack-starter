package com.dlizarra.starter.symbol;

@SuppressWarnings("serial")
public class SymbolNotFoundException extends RuntimeException {

    public SymbolNotFoundException(final Long id) {
        super("Could not find Symbol with id: " + id);
    }
}
