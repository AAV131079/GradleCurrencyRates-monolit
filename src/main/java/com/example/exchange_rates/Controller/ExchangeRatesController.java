package com.example.exchange_rates.Controller;

import com.example.exchange_rates.DTO.Request.RequestDTO;
import com.example.exchange_rates.DTO.Response.ErrorResponseDTO;
import com.example.exchange_rates.DTO.Response.ResponseExchangeRatesDTO;
import com.example.exchange_rates.Service.ExchangeRatesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
@Tag(name = "Exchange rates API.",
     description = "API for obtaining exchange rates using the data of three financial institutions (Monobank, Privatbank, National Bank of Ukraine).")
@RequestMapping("/rates")
public class ExchangeRatesController {

    private ExchangeRatesService exchangeRatesService;

    public ExchangeRatesController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @Operation(summary = "Get average exchange rates on the current day.",
               description = "Request for a list of average exchange rates for all sources on the current day.")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "The request was completed successfully.",
                    content = @Content(schema = @Schema(implementation = ResponseExchangeRatesDTO.class))),
            @ApiResponse(responseCode = "400",
                    description = "Error while executing request.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/current")
    private ResponseEntity<ResponseExchangeRatesDTO> getCurrentRates() throws ParseException {
        return new ResponseEntity<>(exchangeRatesService.getCurrentRates(), HttpStatus.OK);
    }

    @Operation(summary = "Get average exchange rates for the period.",
               description = "Request for a list of average exchange rates for all sources for the period. The start and end dates are specified in the request body.")
    @RequestBody(
            description = "Start and end date in the format: YYYY-MM-DD.",
            required    = true,
            content     = @Content(schema = @Schema(implementation = RequestDTO.class))
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "The request was completed successfully.",
                    content = @Content(schema = @Schema(implementation = ResponseExchangeRatesDTO.class))),
            @ApiResponse(responseCode = "400",
                    description = "Error while executing request.",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/period")
    private ResponseEntity<ResponseExchangeRatesDTO> getCurrentRates(@RequestBody RequestDTO requestDTO) throws ParseException {
        return new ResponseEntity<>(exchangeRatesService.getPeriodRates(requestDTO.getStartDate(), requestDTO.getFinishDate()), HttpStatus.OK);
    }

    @Operation(summary = "Get average exchange rates for the period.",
               description = "Request for a list of average exchange rates for all sources for the period. " +
                             "The start and end date are specified in the request path" +
                             " in the format: /rates/period/start=YYYY-MM-DD/finish=YYYY-MM-DD.",
               parameters = {
                       @Parameter(
                               in = ParameterIn.PATH,
                               name = "startDate",
                               required = true,
                               description = "Period start date in the format: YYYY-MM-DD.",
                               schema = @Schema(allOf = { String.class }),
                               style = ParameterStyle.SIMPLE
                       ),
                       @Parameter(
                               in = ParameterIn.PATH,
                               name = "finishDate",
                               required = true,
                               description = "Period end date in the format: YYYY-MM-DD.",
                               schema = @Schema(allOf = { String.class }),
                               style = ParameterStyle.SIMPLE
                       )
               }
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                         description = "The request was completed successfully.",
                         content = @Content(schema = @Schema(implementation = ResponseExchangeRatesDTO.class))),
            @ApiResponse(responseCode = "400",
                         description = "Error while executing request.",
                         content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/period/start={startDate}/finish={finishDate}")
    private ResponseEntity<ResponseExchangeRatesDTO> getPeriodRates(@PathVariable String startDate, @PathVariable String finishDate) throws ParseException {
        return new ResponseEntity<>(exchangeRatesService.getPeriodRates(startDate, finishDate), HttpStatus.OK);
    }

}