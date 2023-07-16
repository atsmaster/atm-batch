package com.han.atm.batch.step.buy;


import com.han.atm.batch.binance.BinanceClient;
import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.OrderSideCd;
import com.han.atm.batch.domain.code.OrderTypeCd;
import com.han.atm.batch.domain.code.OrderTypeMarketLimitCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BuyStep {


    private final BinanceClient binanceClient;
    public StepStorage run(StepStorage stepStorage){

        Batter batter = stepStorage.getBatter();
        BatterOrder batterOrder = stepStorage.getBatterOrder();

        batterOrder.initialize(
                OrderSideCd.BUY,
                batter.getOrderPositionCd(),
                convert(batter.getBuyOrderTypeMarketLimitCd())
        );


        Map aa = binanceClient.newOrder(stepStorage.getBatterOrder());

        return null;
    }


    private OrderTypeCd convert(OrderTypeMarketLimitCd orderTypeMarketLimitCd){
        OrderTypeCd orderTypeCd = null;
        if(orderTypeMarketLimitCd == OrderTypeMarketLimitCd.MARKET){
            orderTypeCd = OrderTypeCd.MARKET;
        }
        return orderTypeCd;
    }
}
