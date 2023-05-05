package com.example.exchange_rates.DTO.Monobank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCurrencyRatesMonobankDTO {

    public CurrencyRatesMonobankDTO[] currencyRates;

    public ResponseCurrencyRatesMonobankDTO() {
    }

}