package com.dlizarra.starter.holdings;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import com.dlizarra.starter.symbol.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HoldingServiceImpl implements HoldingService {
    @Autowired
    private HoldingRepository holdingRepository;

    @Autowired
    private SymbolService symbolService;

    @Transactional(readOnly = true)
    @Override
    public List<Holding> getHoldings() {

        final List<Holding> holdings = holdingRepository.findAll();
        holdings.forEach(holding -> {
            final String symbolDescription = symbolService.getSymbolByShortcut(holding.getSymbol()).getDescription();
            holding.setSymbolDescription(symbolDescription);
        });
        return holdings;
    }

    @Transactional
    @Override
    public void createHolding(Holding holding) {

        final String symbolDescription = symbolService.getSymbolByShortcut(holding.getSymbol()).getDescription();
        holdingRepository.save(holding);
    }

    @Transactional
    @Override
    public void updateHolding(Holding holding) {
        Optional<Holding> foundHolding = holdingRepository.findOne(holding.getSymbol());
        if (!foundHolding.isPresent()) {
            throw new HoldingNotFoundException(holding.getSymbol());
        }
        holdingRepository.save(holding);
    }

    @Transactional
    @Override
    public void deleteHolding(String symbol) throws HoldingNotFoundException {
        Optional<Holding> holding = holdingRepository.findOne(symbol);
        if (!holding.isPresent()) {
            throw new HoldingNotFoundException(symbol);
        }
        holdingRepository.delete(holding.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Holding getHolding(String symbol) {
        Optional<Holding> holding = holdingRepository.findOne(symbol);
        if (!holding.isPresent()) {
            throw new HoldingNotFoundException(symbol);
        }
        return holding.get();
    }
}
