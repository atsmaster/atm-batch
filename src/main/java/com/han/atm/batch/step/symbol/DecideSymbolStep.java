package com.han.atm.batch.step.symbol;

import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import com.han.atm.batch.domain.repository.BatterExecutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DecideSymbolStep {

    private final DecideSymbolDao decideSymbolDao;
    private final BatterExecutionRepository batterExecutionRepository;

    public StepStorage run(StepStorage stepStorage){

        Batter batter = stepStorage.getBatter();
        BatterExecution batterExecution = stepStorage.getBatterExecution();
        BatterOrder batterOrder = stepStorage.getBatterOrder();

        if(batter.getSymbolDeciderId() == 0){
            List<String> symbols = decideSymbolDao.findSymbolTradingAndUsdt();
            String symbol = symbols.stream()
                    .skip(new Random().nextInt(symbols.size()))
                    .findFirst()
                    .orElse(null);


            batterOrder.setOrderSymbol(symbol);
        }



        batterExecution.setBattingSymbol(batterOrder.getOrderSymbol());
        batterExecutionRepository.save(batterExecution);

        stepStorage.setBatterStatusCd(BatterStatusCd.DECIDE_PRICE);
        return stepStorage;
    }

}
