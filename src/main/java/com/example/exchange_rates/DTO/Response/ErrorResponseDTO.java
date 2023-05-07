package com.example.exchange_rates.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDTO {

    private String errorType;
    private String errorDescription;

    public ErrorResponseDTO(String errorType, String errorDescription) {
        this.errorType = errorType;
        this.errorDescription = errorDescription;
    }

}