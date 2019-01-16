package com.dlizarra.starter.allocations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;

@Slf4j
@Component

public class AllocationInitialiser {
    @Autowired
    private AllocationRepository allocationRepository;

    @PostConstruct
    private void initialiseAllocations() {
        Allocation h01 = new Allocation();
        h01.setSymbol("MSFT");
        h01.setPercentage(new BigDecimal(50.0));
        Allocation h02 = new Allocation();
        h02.setSymbol("BABA");
        h02.setPercentage(new BigDecimal(20.5));
    /*    Allocation h03 = new Allocation();
        h03.setSymbol("ZS");
        h03.setPercentage(new BigDecimal(15)); */

        for (Allocation h : Arrays.asList(h01, h02 /*, h03 */)) {
            allocationRepository.save(h);
            log.info("Saved allocation" + h.getSymbol() + " " + h.getPercentage());
        }

    }
}
