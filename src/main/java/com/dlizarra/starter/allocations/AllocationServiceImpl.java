package com.dlizarra.starter.allocations;

import com.dlizarra.starter.symbol.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    private AllocationRepository allocationRepository;

    @Autowired
    private SymbolService symbolService;

    @Transactional(readOnly = true)
    @Override
    public List<Allocation> getAllocations() {

        final List<Allocation> allocations = allocationRepository.findAll();
        allocations.forEach(allocation -> {
            final String symbolDescription = symbolService.getSymbolByShortcut(allocation.getSymbol()).getDescription();
            allocation.setSymbolDescription(symbolDescription);
        });
        return allocations;
    }

    @Transactional
    @Override
    public void createAllocation(Allocation allocation) {

        final String symbolDescription = symbolService.getSymbolByShortcut(allocation.getSymbol()).getDescription();
        allocationRepository.save(allocation);
    }

    @Transactional
    @Override
    public void updateAllocation(Allocation allocation) {
        Optional<Allocation> foundAllocation = allocationRepository.findOne(allocation.getSymbol());
        if (!foundAllocation.isPresent()) {
            throw new AllocationNotFoundException(allocation.getSymbol());
        }
        allocationRepository.save(allocation);
    }

    @Transactional
    @Override
    public void deleteAllocation(String symbol) throws AllocationNotFoundException {
        Optional<Allocation> allocation = allocationRepository.findOne(symbol);
        if (!allocation.isPresent()) {
            throw new AllocationNotFoundException(symbol);
        }
        allocationRepository.delete(allocation.get());
    }

    @Transactional(readOnly = true)
    @Override
    public Allocation getAllocation(String symbol) {
        Optional<Allocation> allocation = allocationRepository.findOne(symbol);
        if (!allocation.isPresent()) {
            throw new AllocationNotFoundException(symbol);
        }
        return allocation.get();
    }
}
