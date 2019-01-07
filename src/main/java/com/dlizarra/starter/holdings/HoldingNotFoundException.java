package com.dlizarra.starter.holdings;

public class HoldingNotFoundException extends RuntimeException {
    public HoldingNotFoundException(final String shortcut) {
        super("Could not find Holding for Symbol: " + shortcut);
    }
}
