package com.example.exchange_rates.Controller;

import com.example.exchange_rates.Service.ThirdPartyService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@EnableScheduling
public class ThirdPartyController {

    private ThirdPartyService thirdPartyService;

    public ThirdPartyController(ThirdPartyService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @Scheduled(cron = "${interval-in-cron}")
    @Async
    public void getCurrencyRatesFromMonobankProvider() throws IOException {
        thirdPartyService.getCurrencyRatesFromMonobankProvider();
    }

    @Scheduled(cron = "${interval-in-cron}")
    @Async
    public void getCurrencyRatesFromNBUProvider() throws IOException {
        thirdPartyService.getCurrencyRatesFromNBUProvider();
    }

    @Scheduled(cron = "${interval-in-cron}")
    @Async
    public void getCurrencyRatesFromPrivatebankProvider() throws IOException {
        thirdPartyService.getCurrencyRatesFromPrivatebankProvider();
    }

}