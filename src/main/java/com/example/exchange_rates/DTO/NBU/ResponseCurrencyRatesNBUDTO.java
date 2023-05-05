package com.example.exchange_rates.DTO.NBU;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCurrencyRatesNBUDTO {

    public CurrencyRatesNBUDTO[] currencyRates;

    public ResponseCurrencyRatesNBUDTO() {
    }

}