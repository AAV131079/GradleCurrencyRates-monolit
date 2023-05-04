package com.example.exchange_rates.Providers.Impl;

import com.example.exchange_rates.DTO.Monobank.ResponseCurrencyRatesMonobankDTO;
import com.example.exchange_rates.Enum.CurrencyEnum;
import com.example.exchange_rates.Enum.ProviderEnum;
import com.example.exchange_rates.Model.ExchangeRateEntity;
import com.example.exchange_rates.Providers.ProvidersInterface;
import com.example.exchange_rates.Repository.ExchangeRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;
import java.util.Arrays;

@EnableScheduling
public class MonobankProviderImpl implements ProvidersInterface {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getCurrencyRates(ExchangeRateRepository exchangeRateRepository) throws IOException {

        String response = getData("https://api.monobank.ua/bank/currency");

        String modifiedResponse = "{\"currencyRates\":" + response.toString() + "}";
        ResponseCurrencyRatesMonobankDTO responseCurrencyRates = objectMapper.readValue(modifiedResponse, ResponseCurrencyRatesMonobankDTO.class);

        Arrays.stream(responseCurrencyRates.getCurrencyRates())
              .filter(currencyRate -> currencyRate.getCurrencyCodeA() == 840 || currencyRate.getCurrencyCodeA() == 978 &&
                                      currencyRate.getCurrencyCodeB() == 980
              )
              .forEach(currencyRate -> {
                  ExchangeRateEntity exchangeRateDB;
                  if (currencyRate.getCurrencyCodeA() == 840 && currencyRate.getCurrencyCodeB() == 980) {
                      exchangeRateDB = exchangeRateRepository.save(
                              new ExchangeRateEntity(ProviderEnum.MONOBANK,
                                                     CurrencyEnum.USD,
                                                     currencyRate.getRateBuy(),
                                                     currencyRate.getRateSell())
                      );
                  } else if (currencyRate.getCurrencyCodeA() == 978 && currencyRate.getCurrencyCodeB() == 980) {
                      exchangeRateDB = exchangeRateRepository.save(
                              new ExchangeRateEntity(ProviderEnum.MONOBANK,
                                                     CurrencyEnum.EUR,
                                                     currencyRate.getRateBuy(),
                                                     currencyRate.getRateSell())
                      );
                  }
              });

    }

}