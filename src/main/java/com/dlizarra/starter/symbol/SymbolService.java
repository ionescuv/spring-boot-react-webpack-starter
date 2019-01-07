package com.dlizarra.starter.symbol;

import java.util.List;

public interface SymbolService {

    Symbol getSymbol(Long id);

    Symbol getSymbolByShortcut(String shortcut);

    List<Symbol> getSymbols();

}
