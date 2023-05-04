package com.example.exchange_rates.Providers.Impl;

import com.example.exchange_rates.DTO.Privatbank.CurrencyRatesPrivatbankDTO;
import com.example.exchange_rates.DTO.Privatbank.ResponseCurrencyRatesPrivatbankDTO;
import com.example.exchange_rates.Enum.CurrencyEnum;
import com.example.exchange_rates.Enum.ProviderEnum;
import com.example.exchange_rates.Model.ExchangeRateEntity;
import com.example.exchange_rates.Providers.ProvidersInterface;
import com.example.exchange_rates.Repository.ExchangeRateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;

@EnableScheduling
public class PrivatbankProviderImpl implements ProvidersInterface {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getCurrencyRates(ExchangeRateRepository exchangeRateRepository) throws IOException {

        String response = getData("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5");

        String modifiedResponse = "{\"currencyRates\":" + response.toString() + "}";
        ResponseCurrencyRatesPrivatbankDTO responseCurrencyRates = objectMapper.readValue(modifiedResponse, ResponseCurrencyRatesPrivatbankDTO.class);

        for (CurrencyRatesPrivatbankDTO currencyRate : responseCurrencyRates.getCurrencyRates()) {
            ExchangeRateEntity exchangeRateDB;
            if (currencyRate.getCcy().equals(CurrencyEnum.EUR.name())) {
                exchangeRateDB = exchangeRateRepository.save(
                        new ExchangeRateEntity(ProviderEnum.PRIVATBANK,
                                               CurrencyEnum.EUR,
                                               Float.parseFloat(currencyRate.getBuy()),
                                               Float.parseFloat(currencyRate.getSale()))
                );
            } else if (currencyRate.getCcy().equals(CurrencyEnum.USD.name())) {
                exchangeRateDB = exchangeRateRepository.save(
                        new ExchangeRateEntity(ProviderEnum.PRIVATBANK,
                                               CurrencyEnum.USD,
                                               Float.parseFloat(currencyRate.getBuy()),
                                               Float.parseFloat(currencyRate.getSale()))
                );
            }

        }
    }

}