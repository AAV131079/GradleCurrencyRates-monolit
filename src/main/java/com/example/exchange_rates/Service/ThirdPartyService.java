package com.example.exchange_rates.Service;

import com.example.exchange_rates.Providers.Impl.MonobankProviderImpl;
import com.example.exchange_rates.Providers.Impl.NBUProviderImpl;
import com.example.exchange_rates.Providers.Impl.PrivatbankProviderImpl;
import com.example.exchange_rates.Repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class ThirdPartyService {

    private ExchangeRateRepository exchangeRateRepository;

    private PrivatbankProviderImpl privatbankProviderImpl = new PrivatbankProviderImpl();
    private MonobankProviderImpl monobankProviderImpl = new MonobankProviderImpl();
    private NBUProviderImpl nbuProviderImpl = new NBUProviderImpl();

    public ThirdPartyService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public void getCurrencyRatesFromThirdPartyProviders() {
        String dateTime = new Date().toString();
        System.out.println("getCurrencyRatesFromThirdPartyProviders() worked!!! [" + dateTime +  "]");
    }

    public void getCurrencyRatesFromMonobankProvider() throws IOException {
        monobankProviderImpl.getCurrencyRates(exchangeRateRepository);
        String dateTime = new Date().toString();
        System.out.println("getCurrencyRatesFromMonobankProvider() worked!!! [" + dateTime +  "]");
    }

    public void getCurrencyRatesFromNBUProvider() throws IOException {
        nbuProviderImpl.getCurrencyRates(exchangeRateRepository);
        String dateTime = new Date().toString();
        System.out.println("getCurrencyRatesFromNBUProvider() worked!!! [" + dateTime +  "]");
    }

    public void getCurrencyRatesFromPrivatebankProvider() throws IOException {
        privatbankProviderImpl.getCurrencyRates(exchangeRateRepository);
        String dateTime = new Date().toString();
        System.out.println("getCurrencyRatesFromPrivatebankProvider() worked!!! [" + dateTime +  "]");
    }

}