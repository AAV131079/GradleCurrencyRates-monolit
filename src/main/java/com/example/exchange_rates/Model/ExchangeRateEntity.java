package com.example.exchange_rates.Model;

import com.example.exchange_rates.Enum.CurrencyEnum;
import com.example.exchange_rates.Enum.ProviderEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "currency_rates")
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "currency_rates_id")
    private Long currencyRatesId;
    @Column(nullable = false, name = "provider_type")
    private ProviderEnum providerType;
    @Column(nullable = false, name = "currency_type")
    private CurrencyEnum currencyType;
    @Column(nullable = false, name = "buy")
    private Float buy;
    @Column(nullable = false, name = "sale")
    private Float sale;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "create_time")
    private Date createTime;

    public ExchangeRateEntity() {
    }

    public ExchangeRateEntity(ProviderEnum providerType, CurrencyEnum currencyType, Float buy, Float sale) {
        this.providerType = providerType;
        this.currencyType = currencyType;
        this.buy = buy;
        this.sale = sale;
    }

}