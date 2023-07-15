package com.han.atm.batch.step.symbol;

import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DecideSymbolStep {

    private final DecideSymbolDao decideSymbolDao;

    public StepStorage run(StepStorage stepStorage){

        Batter batter = stepStorage.getBatter();
        BatterOrder batterOrder = stepStorage.getBatterOrder();

        if(batter.getSymbolDeciderId() == null){
            List<String> symbols = decideSymbolDao.findSymbolTradingAndUsdt();
            String symbol = symbols.stream().findAny().orElseThrow();
            batterOrder.setOrderSymbol(symbol);
        }

        return stepStorage;
    }

}
