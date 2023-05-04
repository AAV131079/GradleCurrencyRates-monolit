package com.example.exchange_rates.DTO.Monobank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRatesMonobankDTO {

    private Long currencyCodeA;
    private Long currencyCodeB;
    private Date date;
    private Float rateBuy;
    private Long rateCross;
    private Float rateSell;

    public CurrencyRatesMonobankDTO() {
    }

}