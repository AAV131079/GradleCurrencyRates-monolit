package com.example.exchange_rates.Controller;

import com.example.exchange_rates.Service.ThirdPartyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Controller
@EnableScheduling
public class ThirdPartyController {

    private ThirdPartyService thirdPartyService;

    public ThirdPartyController(ThirdPartyService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @Scheduled(cron = "${interval-in-cron}")
    @Async
    public void getCurrencyRatesFromMonobankProvider() throws IOException, InterruptedException {
        log.warn("CurrencyRatesFromMonobankProvider() started!!! [" + new Date().toString() +  "]");
        thirdPartyService.getCurrencyRatesFromMonobankProvider();
        Thread.sleep(2000);
    }

    @Scheduled(cron = "${interval-in-cron}")
    @Async
    public void getCurrencyRatesFromNBUProvider() throws IOException, InterruptedException {
        log.warn("CurrencyRatesFromNBUProvider() started!!! [" + new Date().toString() +  "]");
        thirdPartyService.getCurrencyRatesFromNBUProvider();
        Thread.sleep(2000);
    }

    @Scheduled(cron = "${interval-in-cron}")
    @Async
    public void getCurrencyRatesFromPrivatebankProvider() throws IOException, InterruptedException {
        log.warn("CurrencyRatesFromPrivatebankProvider() started!!! [" + new Date().toString() +  "]");
        thirdPartyService.getCurrencyRatesFromPrivatebankProvider();
        Thread.sleep(2000);
    }

}