package com.dlizarra.starter.symbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymbolController {
    @Autowired
    private SymbolService symbolService;

    @RequestMapping(value = "/api/symbols", method = RequestMethod.GET)
    public List<SymbolDto> getAll() {
        return symbolService.getSymbols();
    }
}
