package com.dlizarra.starter.symbol;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SymbolServiceImpl implements SymbolService {

    @Autowired
    private SymbolRepository symbolRepository;

    @Transactional(readOnly = true)
    @Override
    public Symbol getSymbol(Long id) {
        Optional<Symbol> symbol = symbolRepository.findOne(id);
        if (!symbol.isPresent()) {
            throw new SymbolNotFoundException(id);
        }
        return symbol.get();
    }

    @Override
    public Symbol getSymbolByShortcut(String shortcut) {
        Optional<Symbol> symbol = symbolRepository.findByShortcut(shortcut);
        if (!symbol.isPresent()) {
            throw new SymbolNotFoundException(shortcut);
        }
        return symbol.get();
    }

    @Override
    public List<Symbol> getSymbols() {
        List<Symbol> symbols = symbolRepository.findAll();
        return symbols;
    }
}
