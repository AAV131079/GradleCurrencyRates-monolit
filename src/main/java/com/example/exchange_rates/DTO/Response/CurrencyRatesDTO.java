package com.example.exchange_rates.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRatesDTO {

    private String currency;
    private Float buy;
    private Float sale;

    public CurrencyRatesDTO(String currency, Float buy, Float sale) {
        this.buy = buy;
        this.sale = sale;
        if (Objects.nonNull(this.buy) && this.buy > 0F || Objects.nonNull(this.sale) && this.sale > 0F) {
            this.currency = currency;
        }
    }

}