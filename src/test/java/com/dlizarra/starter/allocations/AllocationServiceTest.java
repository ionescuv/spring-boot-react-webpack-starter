package com.dlizarra.starter.allocations;

import com.dlizarra.starter.support.AbstractUnitTest;
import com.dlizarra.starter.symbol.Symbol;
import com.dlizarra.starter.symbol.SymbolService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Transactional
public class AllocationServiceTest extends AbstractUnitTest {

    @Mock
    private AllocationRepository allocationRepo;

    @Mock
    private SymbolService symbolService;

    @InjectMocks
    private AllocationServiceImpl allocationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<Allocation> allocations = new ArrayList<Allocation>();

        final Allocation allocation1 = new Allocation();
        allocation1.setSymbol("TGN");
        allocation1.setPercentage(new BigDecimal(1.25));
        allocations.add(allocation1);

        final Allocation allocation2 = new Allocation();
        allocation2.setSymbol("TLV");
        allocation2.setPercentage(new BigDecimal(50.00));
        allocations.add(allocation2);

        when(allocationRepo.findAll()).thenReturn(allocations);
        when(allocationRepo.findOne("TLV")).thenReturn(Optional.of(allocation2));
        when(allocationRepo.findOne("Bla")).thenReturn(Optional.empty());

        when(symbolService.getSymbolByShortcut("TLV")).thenReturn(new Symbol());
        when(symbolService.getSymbolByShortcut("TGN")).thenReturn(new Symbol());

    }

    @Test
    public void testFindAll_TwoAllocationsInDb_ShouldReturnTwoAllocations() {
        // act
        final List<Allocation> allocations = allocationService.getAllocations();
        // assert
        assertThat(allocations.size()).isEqualTo(2);
    }

    @Test
    public void testGetAllocation_ExistingIdGiven_ShouldReturnAllocation() {
        // act
        final Allocation allocation = allocationService.getAllocation("TLV");
        // assert
        assertThat(allocation.getPercentage()).isEqualTo(new BigDecimal(50.00));
    }

    @Test(expected = AllocationNotFoundException.class)
    public void testGetAllocation_NonExistingIdGiven_ShouldThrowAllocationNotFoundException() {
        allocationService.getAllocation("Bla");
    }

}
