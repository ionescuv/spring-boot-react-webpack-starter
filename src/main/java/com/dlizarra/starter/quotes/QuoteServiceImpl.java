package com.dlizarra.starter.quotes;

import com.dlizarra.starter.stock_api.AlphaVantageConnector;
import com.dlizarra.starter.symbol.Symbol;
import com.dlizarra.starter.symbol.SymbolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private AlphaVantageConnector apiConnector;

    @Autowired
    private SymbolService symbolService;

    @Transactional(readOnly = true)
    @Override
    public List<Quote> getQuotes() {
        List<Symbol> existingSymbols = symbolService.getSymbols();
        List<Quote> quotes = new ArrayList<Quote>();
        existingSymbols.forEach(symbol -> {
            Quote quote = apiConnector.getQuote(symbol.getShortcut());
            quote.setSymbolDescription(symbol.getDescription());
            quotes.add(quote);
        });
        return quotes;
    }

    @Transactional(readOnly = true)
    @Override
    public Quote getQuote(String symbol) {
        final String symbolDescription = symbolService.getSymbolByShortcut(symbol).getDescription();
        Quote response = apiConnector.getQuote(symbol);
        response.setSymbolDescription(symbolDescription);
        return response;
    }
}
