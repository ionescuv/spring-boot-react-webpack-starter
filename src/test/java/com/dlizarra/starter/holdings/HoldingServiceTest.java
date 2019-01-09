package com.dlizarra.starter.holdings;

import com.dlizarra.starter.support.AbstractUnitTest;
import com.dlizarra.starter.symbol.Symbol;
import com.dlizarra.starter.symbol.SymbolService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Transactional
public class HoldingServiceTest extends AbstractUnitTest {

    @Mock
    private HoldingRepository holdingRepo;

    @Mock
    private SymbolService symbolService;

    @InjectMocks
    private HoldingServiceImpl holdingService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<Holding> holdings = new ArrayList<Holding>();

        final Holding holding1 = new Holding();
        holding1.setSymbol("TGN");
        holding1.setAmount(100);
        holdings.add(holding1);

        final Holding holding2 = new Holding();
        holding2.setSymbol("TLV");
        holding2.setAmount(50);
        holdings.add(holding2);

        when(holdingRepo.findAll()).thenReturn(holdings);
        when(holdingRepo.findOne("TLV")).thenReturn(Optional.of(holding2));
        when(holdingRepo.findOne("Bla")).thenReturn(Optional.empty());

        when(symbolService.getSymbolByShortcut("TLV")).thenReturn(new Symbol());
        when(symbolService.getSymbolByShortcut("TGN")).thenReturn(new Symbol());

    }

    @Test
    public void testFindAll_TwoHoldingsInDb_ShouldReturnTwoHoldings() {
        // act
        final List<Holding> holdings = holdingService.getHoldings();
        // assert
        assertThat(holdings.size()).isEqualTo(2);
    }

    @Test
    public void testGetHolding_ExistingIdGiven_ShouldReturnHolding() {
        // act
        final Holding holding = holdingService.getHolding("TLV");
        // assert
        assertThat(holding.getAmount()).isEqualTo(50);
    }

    @Test(expected = HoldingNotFoundException.class)
    public void testGetHolding_NonExistingIdGiven_ShouldThrowHoldingNotFoundException() {
        holdingService.getHolding("Bla");
    }

}
