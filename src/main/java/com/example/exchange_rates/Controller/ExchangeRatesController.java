package com.example.exchange_rates.Controller;

import com.example.exchange_rates.DTO.Privatbank.ResponseCurrencyRatesPrivatbankDTO;
import com.example.exchange_rates.Service.ExchangeRatesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/rates")
public class ExchangeRatesController {

    private ExchangeRatesService exchangeRatesService;

    public ExchangeRatesController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/current")
    private ResponseEntity<ResponseCurrencyRatesPrivatbankDTO> getCurrentRates() throws IOException {
        return null;
    }

    @GetMapping("/period/start{startDate}/finish{finishDate}")
    private ResponseEntity<String> getPeriodRates(@PathVariable Date startDate, @PathVariable Date finishDate) {
        return null;
    }

}