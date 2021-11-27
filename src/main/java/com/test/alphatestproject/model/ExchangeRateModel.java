package com.test.alphatestproject.model;

import java.util.Map;

public class ExchangeRateModel {

    private String disclaimer;

    private String license;

    private String timestamp;

    private String base;

    private Map<String, Double> rates;

    public ExchangeRateModel() {
    }

    public ExchangeRateModel(String disclaimer, String license, String base, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.base = base;
        this.rates = rates;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

}
