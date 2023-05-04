package com.example.exchange_rates.Service;

import com.example.exchange_rates.Providers.Impl.MonobankProviderImpl;
import com.example.exchange_rates.Providers.Impl.NBUProviderImpl;
import com.example.exchange_rates.Providers.Impl.PrivatbankProviderImpl;
import com.example.exchange_rates.Repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExchangeRatesService {
    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRatesService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public void getCurrentRates() throws IOException {

    }

    public void getPeriodRates(String url) {

    }

}