package com.dlizarra.starter.quotes;

import com.dlizarra.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @Autowired
    private OrikaBeanMapper mapper;

    @RequestMapping(value = "/api/quotes", method = RequestMethod.GET)
    public List<QuoteDto> findAll() {

        List<Quote> quotes = quoteService.getQuotes();
        List<QuoteDto> quotesDto = new ArrayList<QuoteDto>();
        quotes.forEach(quote -> quotesDto.add(mapper.map(quote, QuoteDto.class)));
        return quotesDto;
    }

    @RequestMapping(value = "/api/quotes/{symbol}", method = RequestMethod.GET)
    public QuoteDto findById(@PathVariable String symbol) {
        final Quote quote = quoteService.getQuote(symbol);
        return mapper.map(quote, QuoteDto.class);
    }
}
