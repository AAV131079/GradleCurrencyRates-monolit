package com.example.exchange_rates.DTO.NBU;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRatesNBUDTO {

    private Long r030;
    private String txt;
    private Float rate;
    private String cc;
    private String exchangedate;

    public CurrencyRatesNBUDTO() {
    }

}