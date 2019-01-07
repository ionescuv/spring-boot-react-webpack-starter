package com.dlizarra.starter.symbol;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SymbolController {
    @Autowired
    private SymbolService symbolService;

    @Autowired
    private OrikaBeanMapper mapper;

    @RequestMapping(value = "/api/symbols", method = RequestMethod.GET)
    public List<SymbolDto> getAll() {
        List<Symbol> symbols = symbolService.getSymbols();
        List<SymbolDto> symbolsDto = new ArrayList<SymbolDto>();

        symbols.forEach(symbol -> symbolsDto.add(mapper.map(symbol, SymbolDto.class)));
        return symbolsDto;
    }
}
