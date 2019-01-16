package com.dlizarra.starter.quotes;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuoteDeserializer implements JsonDeserializer<Quote> {
    @Override
    public Quote deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();
        try {
            final JsonObject jsonQuote = jsonObject.get("Global Quote").getAsJsonObject();
            final String symbol = jsonQuote.get("01. symbol").getAsString();
            final BigDecimal price = jsonQuote.get("05. price").getAsBigDecimal();
            final String tradingDate = jsonQuote.get("07. latest trading day").getAsString();

            final Quote quote = new Quote();
            quote.setSymbol(symbol);
            quote.setPrice(price);
            LocalDate tradingDay = LocalDate.parse(tradingDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            quote.setTradingDay(tradingDay);

            return quote;
        } catch (NullPointerException e) {
            System.out.println(jsonObject.toString());
            e.printStackTrace();
        }

        return null;


    }
}
