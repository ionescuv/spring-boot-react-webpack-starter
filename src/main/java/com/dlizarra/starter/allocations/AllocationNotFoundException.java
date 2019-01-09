package com.dlizarra.starter.allocations;

public class AllocationNotFoundException extends RuntimeException {
    public AllocationNotFoundException(final String shortcut) {
        super("Could not find Allocation for Symbol: " + shortcut);
    }
}
