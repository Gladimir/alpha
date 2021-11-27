package com.test.alphatestproject.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.alphatestproject.model.GifModel;
import com.test.alphatestproject.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/compare")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping(value = "/{currencyCode}")
    public ModelAndView currencyCompare(@PathVariable String currencyCode) throws JsonProcessingException {

        GifModel gifModel = exchangeService.compareCurrencies(currencyCode);

        String embedUrl = gifModel.getData().getEmbed_url();

        return new ModelAndView("redirect:" + embedUrl);
    }
}
