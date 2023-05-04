package com.example.exchange_rates.Providers.Impl;

import com.example.exchange_rates.DTO.NBU.ResponseCurrencyRatesNBUDTO;
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
public class NBUProviderImpl implements ProvidersInterface {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getCurrencyRates(ExchangeRateRepository exchangeRateRepository) throws IOException {

        String response = getData("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");

        String modifiedResponse = "{\"currencyRates\":" + response.toString() + "}";
        ResponseCurrencyRatesNBUDTO responseCurrencyRates = objectMapper.readValue(modifiedResponse, ResponseCurrencyRatesNBUDTO.class);

        Arrays.stream(responseCurrencyRates.currencyRates)
              .filter(currencyRate -> currencyRate.getCc().equals(CurrencyEnum.EUR.name()) ||
                                      currencyRate.getCc().equals(CurrencyEnum.USD.name())
              )
              .forEach(currencyRate -> {
                  ExchangeRateEntity exchangeRateDB;
                  if (currencyRate.getCc().equals(CurrencyEnum.EUR.name())) {
                      exchangeRateDB = exchangeRateRepository.save(
                              new ExchangeRateEntity(ProviderEnum.NBU,
                                                     CurrencyEnum.EUR,
                                                     currencyRate.getRate(),
                                                     currencyRate.getRate())
                      );
                  } else if (currencyRate.getCc().equals(CurrencyEnum.USD.name())) {
                      exchangeRateDB = exchangeRateRepository.save(
                              new ExchangeRateEntity(ProviderEnum.NBU,
                                                     CurrencyEnum.USD,
                                                     currencyRate.getRate(),
                                                     currencyRate.getRate())
                      );
                  }
              });

    }

}