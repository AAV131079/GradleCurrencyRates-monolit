package com.example.exchange_rates.DTO.Privatbank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCurrencyRatesPrivatbankDTO {

    public CurrencyRatesPrivatbankDTO[] currencyRates;

    public ResponseCurrencyRatesPrivatbankDTO() {
    }

}