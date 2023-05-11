package com.example.exchange_rates.Service;

import com.example.exchange_rates.DTO.Response.CurrencyRatesDTO;
import com.example.exchange_rates.DTO.Response.ResponseExchangeRatesDTO;
import com.example.exchange_rates.Enum.CurrencyEnum;
import com.example.exchange_rates.Repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class ExchangeRatesService {
    private ExchangeRateRepository exchangeRateRepository;

    private static int SIZE = 2;
    private static String CURRENT_DATE = "The average exchange rate for today (Privatbank, Monobank, NBU)";
    private static String PERIOD_DATE = "The average exchange rate for period (Privatbank, Monobank, NBU)";

    public ExchangeRatesService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ResponseExchangeRatesDTO getCurrentRates() throws ParseException {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return getResponseExchangeRatesDTO(date, date);
    }

    public ResponseExchangeRatesDTO getPeriodRates(String startDate, String finishDate) throws ParseException {
        return getResponseExchangeRatesDTO(startDate, finishDate);
    }

    private ResponseExchangeRatesDTO getResponseExchangeRatesDTO(String startDate, String finishDate) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date start = format.parse(startDate + " 00:00:00.000");
        Date finish = format.parse(finishDate + " 23:59:59.999");

        ResponseExchangeRatesDTO responseExchangeRates = new ResponseExchangeRatesDTO(startDate + " 00:00:00.000", finishDate + " 23:59:59.999", PERIOD_DATE);

        Float averageBuyByPeriodEUR = exchangeRateRepository.averageBuyByPeriod(CurrencyEnum.EUR, start, finish);
        Float averageSaleByPeriodEUR = exchangeRateRepository.averageSaleByPeriod(CurrencyEnum.EUR, start, finish);
        Float averageBuyByPeriodUSD = exchangeRateRepository.averageBuyByPeriod(CurrencyEnum.USD, start, finish);
        Float averageSaleByPeriodUSD = exchangeRateRepository.averageSaleByPeriod(CurrencyEnum.USD, start, finish);

        CurrencyRatesDTO currencyRatesEUR = getNewCurrencyRatesDTO(CurrencyEnum.EUR.name(), averageBuyByPeriodEUR, averageSaleByPeriodEUR);
        CurrencyRatesDTO currencyRatesUSD = getNewCurrencyRatesDTO(CurrencyEnum.USD.name(), averageBuyByPeriodUSD, averageSaleByPeriodUSD);

        if (Objects.isNull(currencyRatesEUR) && Objects.isNull(currencyRatesUSD)) {
            responseExchangeRates.setCurrencyRates(null);
            responseExchangeRates.setMessage("Nothing was found in the specified period.");
        } else {
            CurrencyRatesDTO[] currencyRates = new CurrencyRatesDTO[] {
                    Objects.nonNull(currencyRatesEUR) ? currencyRatesEUR : null,
                    Objects.nonNull(currencyRatesUSD) ? currencyRatesUSD : null
            };
            responseExchangeRates.setCurrencyRates(currencyRates);
        }

        return responseExchangeRates;

    }

    private CurrencyRatesDTO getNewCurrencyRatesDTO(String currency, Float buy, Float sale) {
        if (Objects.nonNull(buy) && buy > 0F || Objects.nonNull(sale) && sale > 0F) {
            return new CurrencyRatesDTO(currency, buy, sale);
        } else {
            return null;
        }
    }

}