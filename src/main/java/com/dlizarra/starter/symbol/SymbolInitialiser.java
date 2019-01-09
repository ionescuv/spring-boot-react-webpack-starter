package com.dlizarra.starter.symbol;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Component

public class SymbolInitialiser {
    @Autowired
    private SymbolRepository symbolRepository;

    @PostConstruct
    private void initialiseSymbols() {
        Symbol s01 = new Symbol("MSFT", "Microsoft Corporation");
        Symbol s02 = new Symbol("BABA", "Alibaba Group Holding Limited");
        Symbol s03 = new Symbol("ZS", "Zscaler Inc.");

        for (Symbol s : Arrays.asList(s01, s02, s03)) {
            symbolRepository.save(s);
            log.info("Saved symbol" + s.getShortcut() + " " + s.getDescription());
        }

    }
}
