package com.han.atm.batch.batter;


import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.step.buy.BuyStep;
import com.han.atm.batch.step.price.DecidePriceStep;
import com.han.atm.batch.step.start.StartStep;
import com.han.atm.batch.step.symbol.DecideSymbolStep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatterAsync {
    private static final Logger logger = LoggerFactory.getLogger(BatterAsync.class);

    private final StartStep startStep;
    private final DecidePriceStep decidePriceStep;
    private final DecideSymbolStep decideSymbolStep;
    private final BuyStep buyStep;

    @Async("asyncExecutor")
    public void run(Batter batter, int batterGroupExecutionId) {

        StepStorage stepStorage = startStep.run(batter, batterGroupExecutionId);

        while (true){
            switch (stepStorage.getBatterStatusCd()){
                case STOPPING_REQUEST_CHECK -> {

                }case DECIDE_SYMBOL -> {
                    decideSymbolStep.run(stepStorage);
                }case DECIDE_PRICE -> {
                    decidePriceStep.run(stepStorage);
                }case BUYING -> {
                    buyStep.run(stepStorage);
                }case SELLING -> {

                }case SETTLING -> {

                }case STOP -> {

                }
            }

        }


    }
}
