package com.han.atm.batch.step.price;

import com.han.atm.batch.binance.BinanceClient;
import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import com.han.atm.batch.domain.repository.CoinEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DecidePriceStep {

    private final DecidePriceDao decidePriceDao;
    private final BinanceClient binanceClient;
    private final CoinEntryRepository coinEntryRepository;

    public StepStorage run(StepStorage stepStorage){
        Batter batter = stepStorage.getBatter();
        BatterExecution batterExecution = stepStorage.getBatterExecution();
        BatterOrder batterOrder = stepStorage.getBatterOrder();

        BatterOrder prevFilledOrder = decidePriceDao.findPrevFilledOrder(batterExecution.getBatterExecutionId());
        BigDecimal symbolMarketPrice = binanceClient.getMarketPriceBySymobol(batterExecution.getBattingSymbol());


        int quoteAssetPrecision = coinEntryRepository.findByExchangeAndSymbol("binance", batterOrder.getOrderSymbol()).getQuoteAssetPrecision();
        if(prevFilledOrder == null){ // 첫 배팅
            BigDecimal firstBattingAmount = batter.getFirstBattingPrice();
            BigDecimal baseQuantity =  firstBattingAmount.divide(symbolMarketPrice, quoteAssetPrecision, BigDecimal.ROUND_HALF_UP);

            batterOrder.setOrderQuantity(baseQuantity);
        }else{
            switch ( prevFilledOrder.getOrderTypeCd()){
                case STOP_MARKET -> {
                    BigDecimal transactionTotalAmount = prevFilledOrder.getTransactionTotalAmount();
                    BigDecimal newOrderAmount = transactionTotalAmount.multiply(batter.getRetryIncrementPriceRate());
                    BigDecimal baseQuantity = newOrderAmount.divide(symbolMarketPrice, quoteAssetPrecision, BigDecimal.ROUND_HALF_UP);

                    batterOrder.setOrderQuantity(baseQuantity);
                }
                case TAKE_PROFIT_MARKET -> {
                    BigDecimal firstBattingAmount = batter.getFirstBattingPrice();
                    BigDecimal baseQuantity =  firstBattingAmount.divide(symbolMarketPrice, quoteAssetPrecision, BigDecimal.ROUND_HALF_UP);

                    batterOrder.setOrderQuantity(baseQuantity);
                }
                default -> {
                    new NoSuchMethodError("DecidePriceStep : No");
                }
            }
        }

        stepStorage.setBatterStatusCd(BatterStatusCd.BUYING);
        return stepStorage;
    }

}
