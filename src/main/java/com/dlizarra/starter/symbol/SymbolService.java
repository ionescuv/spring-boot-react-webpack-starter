package com.dlizarra.starter.symbol;

import java.util.List;

public interface SymbolService {

    Symbol getSymbol(Long id) throws SymbolNotFoundException;

    Symbol getSymbolByShortcut(String shortcut) throws SymbolNotFoundException;

    List<Symbol> getSymbols();

}
