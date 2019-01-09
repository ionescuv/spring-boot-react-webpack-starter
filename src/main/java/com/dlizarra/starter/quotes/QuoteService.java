package com.dlizarra.starter.quotes;

import java.util.List;

public interface QuoteService {
    List<Quote> getQuotes();

    Quote getQuote(String symbol);
}
