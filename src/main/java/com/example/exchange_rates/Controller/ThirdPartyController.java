package com.example.exchange_rates.Controller;

import com.example.exchange_rates.Service.ThirdPartyService;
import lombok.extern.slf4j.Slf4j;
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

    @Scheduled(cron = "${scheduler.cron}")
    public void getCurrencyRatesFromMonobankProvider() throws IOException, InterruptedException {
        log.warn("CurrencyRatesFromMonobankProvider() started!!! [ time: {}], [ thread: {}]", new Date(),
                Thread.currentThread().getName());
        thirdPartyService.getCurrencyRatesFromMonobankProvider();
        Thread.sleep(2000);
    }

    @Scheduled(cron = "${scheduler.cron}")
    public void getCurrencyRatesFromNBUProvider() throws IOException, InterruptedException {
        log.warn("CurrencyRatesFromMonobankProvider() started!!! [ time: {}], [ thread: {}]", new Date(),
                Thread.currentThread().getName());
        thirdPartyService.getCurrencyRatesFromNBUProvider();
        Thread.sleep(2000);
    }

    @Scheduled(cron = "${scheduler.cron}")
    public void getCurrencyRatesFromPrivatebankProvider() throws IOException, InterruptedException {
        log.warn("CurrencyRatesFromMonobankProvider() started!!! [ time: {}], [ thread: {}]", new Date(),
                Thread.currentThread().getName());
        thirdPartyService.getCurrencyRatesFromPrivatebankProvider();
        Thread.sleep(2000);
    }

}