package com.example.exchange_rates.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.util.Objects;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrencyRatesDTO {

    @Schema(description = "Currency type", example = "USD")
    private String currency;
    @Schema(description = "Buy rate", example = "37.55")
    private Float buy;
    @Schema(description = "Sale rate", example = "38.70")
    private Float sale;

    public CurrencyRatesDTO(String currency, Float buy, Float sale) {
        this.buy = buy;
        this.sale = sale;
        if (Objects.nonNull(this.buy) && this.buy > 0F || Objects.nonNull(this.sale) && this.sale > 0F) {
            this.currency = currency;
        }
    }

}