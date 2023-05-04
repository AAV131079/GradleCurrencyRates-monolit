package com.example.exchange_rates.DTO.Privatbank;

import com.example.exchange_rates.DTO.Privatbank.CurrencyRatesPrivatbankDTO;
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