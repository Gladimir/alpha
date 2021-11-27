package com.test.alphatestproject.Data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="giphy-ws", url = "${giphy-ws.url}")
public interface GiphyServiceClient {

    @GetMapping("${gif.uri}")
    String gif(@PathVariable String tag);
}
