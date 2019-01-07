package com.dlizarra.starter.symbol;

@SuppressWarnings("serial")
public class SymbolNotFoundException extends RuntimeException {

    public SymbolNotFoundException(final Long id) {
        super("Could not find Symbol with id: " + id);
    }

    public SymbolNotFoundException(final String shortcut) {
        super("Could not find Symbol with shortcut: " + shortcut);
    }
}
