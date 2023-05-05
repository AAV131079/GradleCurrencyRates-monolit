package com.example.exchange_rates.Repository;

import com.example.exchange_rates.Enum.CurrencyEnum;
import com.example.exchange_rates.Model.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

    @Query("select AVG(exchangeRates.sale) from ExchangeRateEntity exchangeRates " +
            "where exchangeRates.createTime between :start and :finish and exchangeRates.currencyType = :currencyEnum")
    Float averageBuyByPeriod(CurrencyEnum currencyEnum, Date start, Date finish);

    @Query("select AVG(exchangeRates.sale) from ExchangeRateEntity exchangeRates " +
            "where exchangeRates.createTime between :start and :finish and exchangeRates.currencyType = :currencyEnum")
    Float averageSaleByPeriod(CurrencyEnum currencyEnum, Date start, Date finish);

}