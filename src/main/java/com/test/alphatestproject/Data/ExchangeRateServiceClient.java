package com.test.alphatestproject.Data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="exchange-ws", url="${exchange-ws.url}")
public interface ExchangeRateServiceClient
{
    @GetMapping("${rates.uri}")
    String ratesUsd(@PathVariable String date, @PathVariable String code);
}
