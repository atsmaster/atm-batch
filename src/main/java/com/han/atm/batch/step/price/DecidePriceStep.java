package com.han.atm.batch.step.price;

import com.han.atm.batch.binance.BinanceClient;
import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DecidePriceStep {

    private final DecidePriceDao decidePriceDao;
    private final BinanceClient binanceClient;

    public StepStorage run(StepStorage stepStorage){
        Batter batter = stepStorage.getBatter();
        BatterExecution batterExecution = stepStorage.getBatterExecution();

        BatterOrder prevFilledOrder = decidePriceDao.findPrevFilledOrder(batterExecution.getBatterExecutionId());
        BigDecimal symbolMarketPrice = binanceClient.getMarketPriceBySymobol(batterExecution.getBattingSymbol());

        int quoteAssetPrecision = 7; // 해당 종목의 quote_asset_precision 컬럼 읽어오기
        if(prevFilledOrder == null){ // 첫 배팅
            BigDecimal firstBattingAmount = batter.getFirstBattingPrice();
            BigDecimal baseQuantity =  firstBattingAmount.divide(symbolMarketPrice).setScale(quoteAssetPrecision, BigDecimal.ROUND_HALF_UP);

            stepStorage.setOrderQuantity(baseQuantity);
            stepStorage.setBatterStatusCd(BatterStatusCd.BUYING);
        }else{
            switch ( prevFilledOrder.getOrderTypeCd()){
                case STOP_MARKET -> {
                    BigDecimal transactionTotalAmount = prevFilledOrder.getTransactionTotalAmount();
                    BigDecimal newOrderAmount = transactionTotalAmount.multiply(batter.getRetryIncrementPriceRate());
                    BigDecimal baseQuantity = newOrderAmount.divide(symbolMarketPrice).setScale(quoteAssetPrecision, BigDecimal.ROUND_HALF_UP);

                    stepStorage.setOrderQuantity(baseQuantity);
                    stepStorage.setBatterStatusCd(BatterStatusCd.BUYING);
                }
                case TAKE_PROFIT_MARKET -> {
                    BigDecimal firstBattingAmount = batter.getFirstBattingPrice();
                    BigDecimal baseQuantity =  firstBattingAmount.divide(symbolMarketPrice).setScale(quoteAssetPrecision, BigDecimal.ROUND_HALF_UP);

                    stepStorage.setOrderQuantity(baseQuantity);
                    stepStorage.setBatterStatusCd(BatterStatusCd.BUYING);
                }
                default -> {
                    new NoSuchMethodError("DecidePriceStep : No");
                }
            }
        }

        return stepStorage;
    }

}
