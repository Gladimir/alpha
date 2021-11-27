package com.test.alphatestproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.alphatestproject.model.GifModel;

public interface ExchangeService {
    GifModel compareCurrencies(String code) throws JsonProcessingException;
}
