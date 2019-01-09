package com.dlizarra.starter.stock_api;


public class ApiParameterBuilder {

    private StringBuilder urlBuilder;

    public ApiParameterBuilder() {
        this.urlBuilder = new StringBuilder();
    }

    public void append(String key, String value) {
        String parameter = "&" + key + "=" + value;
        this.urlBuilder.append(parameter);
    }

    public String getUrl() {
        return this.urlBuilder.toString();
    }
}
