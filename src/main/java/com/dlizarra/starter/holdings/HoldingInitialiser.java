package com.dlizarra.starter.holdings;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Component

public class HoldingInitialiser {
    @Autowired
    private HoldingRepository holdingRepository;

    @PostConstruct
    private void initialiseHoldings() {
        Holding h01 = new Holding();
        h01.setSymbol("MSFT");
        h01.setAmount(100);
        Holding h02 = new Holding();
        h02.setSymbol("BABA");
        h02.setAmount(550);
        Holding h03 = new Holding();
        h03.setSymbol("ZS");
        h03.setAmount(200);

        for (Holding h : Arrays.asList(h01, h02, h03)) {
            holdingRepository.save(h);
            log.info("Saved holding" + h.getSymbol() + " " + h.getAmount());
        }

    }
}
