package com.han.atm.batch.config;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceConfig {
    @Value("${binance.future.api-key}")
    private String apiKey;
    @Value("${binance.future.secret-key}")
    private String secKey;
    @Value("${binance.future.base-url}")
    private String baseUrl;

    @Bean
    public UMFuturesClientImpl uMFuturesClientImpl() {
        UMFuturesClientImpl client = new UMFuturesClientImpl(apiKey, secKey, baseUrl);
        return client;
    }

}
