package com.example.exchange_rates.DTO.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestDTO {
    private String startDate;
    private String finishDate;

    public RequestDTO() {
    }

}