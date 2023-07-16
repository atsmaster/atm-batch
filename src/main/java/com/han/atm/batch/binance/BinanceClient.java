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
        LinkedHashMap parameter = new LinkedHashMap<String ,Object>();
        parameter.put("symbol", symbol);

        HashMap response = gson.fromJson(client.market().markPrice(parameter), HashMap.class);
        String markPrice =  response.get("markPrice").toString();
        return new BigDecimal(markPrice);
    }

    public Map newOrder(BatterOrder batterOrder){
        Gson gson = new Gson();
        LinkedHashMap parameter = new LinkedHashMap<String ,Object>();
        parameter.put("symbol", batterOrder.getOrderSymbol());
        parameter.put("side", batterOrder.getOrderSideCd().toString());
        parameter.put("position", batterOrder.getOrderPositionCd().toString());
        parameter.put("type", batterOrder.getOrderTypeCd().toString());
        parameter.put("quantity", batterOrder.getOrderQuantity().toString());
        return gson.fromJson(client.account().newOrder(parameter), HashMap.class);
    }
}
