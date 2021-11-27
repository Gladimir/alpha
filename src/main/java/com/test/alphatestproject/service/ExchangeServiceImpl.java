package com.test.alphatestproject.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.test.alphatestproject.Data.ExchangeRateServiceClient;
import com.test.alphatestproject.Data.GiphyServiceClient;
import com.test.alphatestproject.model.ExchangeRateModel;
import com.test.alphatestproject.model.GifModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    ExchangeRateServiceClient exchangeRateServiceClient;
    @Autowired
    GiphyServiceClient giphyServiceClient;

    @Override
    public GifModel compareCurrencies(String code) throws JsonProcessingException {

        String todayRates = exchangeRateServiceClient.ratesUsd(LocalDate.now().toString(), code);

        String yesterdayRates = exchangeRateServiceClient
                .ratesUsd(LocalDate.now().minus(Period.ofDays(1)).toString(), code);

        ExchangeRateModel todayRatesModel = new Gson().fromJson(todayRates, ExchangeRateModel.class);
        ExchangeRateModel yesterdayRatesModel = new Gson().fromJson(yesterdayRates, ExchangeRateModel.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        if (compareCurrenciesRates(todayRatesModel, yesterdayRatesModel, code)) {
            GifModel richGif = mapper.readValue(giphyServiceClient.gif("rich"), GifModel.class);
            return richGif;
        } else {
            GifModel brokeGif = mapper.readValue(giphyServiceClient.gif("broke"), GifModel.class);
            return brokeGif;
        }
    }

    public boolean compareCurrenciesRates(ExchangeRateModel todayRates, ExchangeRateModel yesterdayRates, String code) {
        return todayRates.getRates().get(code.toUpperCase()) > yesterdayRates.getRates().get(code.toUpperCase());
    }
}
