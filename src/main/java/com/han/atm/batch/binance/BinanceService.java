package com.han.atm.batch.binance;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class BinanceService {

    private final UMFuturesClientImpl client;

    public BigDecimal getMarketPriceBySymobol(String symbol){
        Gson gson = new Gson();
        HashMap response = gson.fromJson(client.market().markPrice(new LinkedHashMap<String, Object>(){{put("symbol", symbol);}}), HashMap.class);
        String markPrice =  response.get("markPrice").toString();
        return new BigDecimal(markPrice);
    }
}
