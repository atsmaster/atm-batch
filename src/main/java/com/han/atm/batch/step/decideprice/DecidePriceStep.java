package com.han.atm.batch.step.decideprice;

import com.binance.connector.futures.client.exceptions.BinanceClientException;
import com.binance.connector.futures.client.exceptions.BinanceConnectorException;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.han.atm.batch.binance.BinanceService;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.code.OrderTypeCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import com.han.atm.batch.domain.service.BatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
@RequiredArgsConstructor
public class DecidePriceStep {

    private final BatterService batterService;
    private final DecidePriceDao decidePriceDao;
    private final BinanceService binanceService;


    public BatterStatusCd run(BatterExecution batterExecution){
        BatterStatusCd nextBatterStatusCd = null;
        Batter batter = batterService.findBatterById(batterExecution.getBatterId());
        BatterOrder maxFilledOrder = decidePriceDao.findMaxFilledOrder();


        if(maxFilledOrder == null){

            BigDecimal symbolMarketPrice = binanceService.getMarketPriceBySymobol(batterExecution.getBattingSymbol());
            batter.getFirstBattingPrice().divide(symbolMarketPrice);

        }else{
            switch ( maxFilledOrder.getOrderTypeCd()){
                case STOP_MARKET -> {

                    BigDecimal transactionTotalAmount = maxFilledOrder.getTransactionTotalAmount();

                    BigDecimal newOrderPrice = transactionTotalAmount.multiply(batter.getRetryIncrementPriceRate());

                    LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
                    UMFuturesClientImpl client = new UMFuturesClientImpl();
                    String result = client.market().markPrice(parameters);
                    int a = 0;

                }
                case TAKE_PROFIT_MARKET -> {

                }
            }
        }
        return null;
    }

}
