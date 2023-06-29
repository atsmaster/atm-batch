package com.han.atm.batch.step.decideprice;

import com.han.atm.batch.binance.BinanceClient;
import com.han.atm.batch.binance.vo.MarketBuyOrder;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import com.han.atm.batch.domain.service.BatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DecidePriceStep {

    private final BatterService batterService;
    private final DecidePriceDao decidePriceDao;
    private final BinanceClient binanceClient;


    public BatterStatusCd run(BatterExecution batterExecution, MarketBuyOrder batterOrder){
        //결과값
        BatterStatusCd nextBatterStatusCd = null;
        BigDecimal baseQuantity;

        Batter batter = batterService.findBatterById(batterExecution.getBatterId());
        BatterOrder maxFilledOrder = decidePriceDao.findMaxFilledOrder();
        BigDecimal symbolMarketPrice = binanceClient.getMarketPriceBySymobol(batterExecution.getBattingSymbol());
        int quoteAssetPrecision = 7; // 해당 종목의 quote_asset_precision 컬럼 읽어오기
        if(maxFilledOrder == null){ // 첫 배팅
            BigDecimal firstBattingAmount = batter.getFirstBattingPrice();
            baseQuantity =  firstBattingAmount.divide(symbolMarketPrice).setScale(quoteAssetPrecision, BigDecimal.ROUND_HALF_UP); // Base Quantity
        }else{
            switch ( maxFilledOrder.getOrderTypeCd()){
                case STOP_MARKET -> {

                    BigDecimal transactionTotalAmount = maxFilledOrder.getTransactionTotalAmount();
                    BigDecimal newOrderAmount = transactionTotalAmount.multiply(batter.getRetryIncrementPriceRate());
                    baseQuantity = newOrderAmount.divide(symbolMarketPrice).setScale(quoteAssetPrecision, BigDecimal.ROUND_HALF_UP); // Base Quantity
                }
                case TAKE_PROFIT_MARKET -> {
                    BigDecimal firstBattingAmount = batter.getFirstBattingPrice();
                    baseQuantity =  firstBattingAmount.divide(symbolMarketPrice).setScale(quoteAssetPrecision, BigDecimal.ROUND_HALF_UP); // Base Quantity
                }
                default -> {
                    new NoSuchMethodError("DecidePriceStep : No");
                }
            }
        }


        return null;
    }

}
