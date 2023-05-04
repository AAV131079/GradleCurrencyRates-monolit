package com.example.exchange_rates.DTO.Privatbank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRatesPrivatbankDTO {

    private String ccy;
    private String base_ccy;
    private String buy;
    private String sale;

    public CurrencyRatesPrivatbankDTO() {
    }

}