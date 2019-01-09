package com.dlizarra.starter.stock_api;

import com.dlizarra.starter.quotes.Quote;
import com.dlizarra.starter.quotes.QuoteDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Setter
@Getter
@Slf4j
@Component
public class AlphaVantageConnector {
    private static final String BASE_URL = "https://www.alphavantage.co/query?";
    private static final String FUNCTION = "GLOBAL_QUOTE";
    private final String apiKey = "BPQ7ODWXA72SJ5XW";
    private final int timeOut = 3000;

    @Autowired
    private RestTemplate restTemplate;
    private Gson gson;

    public AlphaVantageConnector() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Quote.class, new QuoteDeserializer());
        this.gson = gsonBuilder.create();
    }

    public Quote getQuote(String symbol) {
        String params = getParameters(symbol);
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + params, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new AlphaVantageException("HTTP Status is not OK");
        }
        Quote quote = gson.fromJson(response.getBody(), Quote.class);
        log.info(quote.toString());
        return quote;
    }

    private String getParameters(String symbol) {
        ApiParameterBuilder urlBuilder = new ApiParameterBuilder();
        urlBuilder.append("function", FUNCTION);
        urlBuilder.append("symbol", symbol);
        urlBuilder.append("apikey", apiKey);
        return urlBuilder.getUrl();
    }
}