package com.example.exchange_rates.Controller;

import com.example.exchange_rates.DTO.Request.RequestDTO;
import com.example.exchange_rates.DTO.Response.ResponseExchangeRatesDTO;
import com.example.exchange_rates.Service.ExchangeRatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
@RequestMapping("/rates")
public class ExchangeRatesController {

    private ExchangeRatesService exchangeRatesService;

    public ExchangeRatesController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/current")
    private ResponseEntity<ResponseExchangeRatesDTO> getCurrentRates() throws ParseException {
        return new ResponseEntity<>(exchangeRatesService.getCurrentRates(), HttpStatus.OK);
    }

    @GetMapping("/period")
    private ResponseEntity<ResponseExchangeRatesDTO> getCurrentRates(@RequestBody RequestDTO requestDTO) throws ParseException {
        return new ResponseEntity<>(exchangeRatesService.getPeriodRates(requestDTO.getStartDate(), requestDTO.getFinishDate()), HttpStatus.OK);
    }

    @GetMapping("/period/start={startDate}/finish={finishDate}")
    private ResponseEntity<ResponseExchangeRatesDTO> getPeriodRates(@PathVariable String startDate, @PathVariable String finishDate) throws ParseException {
        return new ResponseEntity<>(exchangeRatesService.getPeriodRates(startDate, finishDate), HttpStatus.OK);
    }

}