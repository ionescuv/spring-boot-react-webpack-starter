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

    @Autowired
    private OrikaBeanMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public SymbolDto getSymbol(Long id) {
        Optional<Symbol> symbol = symbolRepository.findOne(id);
        if (!symbol.isPresent()) {
            throw new SymbolNotFoundException(id);
        }
        return mapper.map(symbol, SymbolDto.class);
    }

    @Override
    public List<SymbolDto> getSymbols() {
        List<Symbol> symbols = symbolRepository.findAll();
        List<SymbolDto> symbolsDto = new ArrayList<SymbolDto>();
        symbols.forEach(symbol -> symbolsDto.add(mapper.map(symbol, SymbolDto.class)));
        return symbolsDto;
    }
}
