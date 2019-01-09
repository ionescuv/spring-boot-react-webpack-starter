package com.dlizarra.starter.allocations;

import java.util.List;

public interface AllocationService {

    List<Allocation> getAllocations();

    void createAllocation(Allocation allocation);

    void updateAllocation(Allocation allocation);

    void deleteAllocation(String symbol);

    Allocation getAllocation(String symbol);
}
