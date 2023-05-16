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

    public void getCurrencyRatesFromMonobankProvider() throws IOException {
        monobankProviderImpl.getCurrencyRates(exchangeRateRepository);
    }

    public void getCurrencyRatesFromNBUProvider() throws IOException {
        nbuProviderImpl.getCurrencyRates(exchangeRateRepository);
    }

    public void getCurrencyRatesFromPrivatebankProvider() throws IOException {
        privatbankProviderImpl.getCurrencyRates(exchangeRateRepository);
    }

}