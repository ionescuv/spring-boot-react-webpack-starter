package com.dlizarra.starter.holdings;

import java.util.List;

public interface HoldingService {

    List<Holding> getHoldings();

    void createHolding(Holding holding);

    void updateHolding(Holding holding);

    void deleteHolding(String symbol);

    Holding getHolding(String symbol);
}
