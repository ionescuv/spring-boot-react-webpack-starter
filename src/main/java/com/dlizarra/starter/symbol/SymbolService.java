package com.dlizarra.starter.symbol;

import java.util.List;

public interface SymbolService {

    SymbolDto getSymbol(Long id);

    List<SymbolDto> getSymbols();

}
