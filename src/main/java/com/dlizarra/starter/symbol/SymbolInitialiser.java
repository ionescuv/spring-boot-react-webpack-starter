package com.dlizarra.starter.symbol;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
        Symbol s01 = new Symbol("TLV", "Ceva");
        Symbol s02 = new Symbol("TGN", "Ceva1");
        Symbol s03 = new Symbol("TLB", "Ceva2");

        for (Symbol s : Arrays.asList(s01, s02, s03)) {
            symbolRepository.save(s);
            log.info("Saved symbol" + s.getShortcut() + " " + s.getDescription());
        }

    }
}
