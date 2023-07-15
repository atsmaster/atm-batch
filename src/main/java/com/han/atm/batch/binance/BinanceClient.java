package com.han.atm.batch.binance;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.google.gson.Gson;
import com.han.atm.batch.domain.entity.BatterOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BinanceClient {

    private final UMFuturesClientImpl client;

    public BigDecimal getMarketPriceBySymobol(String symbol){
        Gson gson = new Gson();
        HashMap response = gson.fromJson(client.market().markPrice(new LinkedHashMap(){{put("symbol", symbol);}}), HashMap.class);
        String markPrice =  response.get("markPrice").toString();
        return new BigDecimal(markPrice);
    }

    public BigDecimal newOrder(BatterOrder batterOrder){
        Gson gson = new Gson();
        LinkedHashMap parameter = (LinkedHashMap) Map.of(
                "symbol", batterOrder.getOrderSymbol(),
                "side", batterOrder.getOrderSide(),
                "position", batterOrder.getOrderPositionCd(),
                "t", "");

        gson.fromJson(client.account().newOrder(parameter), HashMap.class);

        return null;
    }
}
