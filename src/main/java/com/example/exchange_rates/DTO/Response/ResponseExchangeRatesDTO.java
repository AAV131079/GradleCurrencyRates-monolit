package com.example.exchange_rates.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseExchangeRatesDTO {

    private String description;
    private Date startDate;
    private Date finishDate;
    private String message;
    private CurrencyRatesDTO[] currencyRates;

    public ResponseExchangeRatesDTO(Date startDate, Date finishDate, String description) {
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

}