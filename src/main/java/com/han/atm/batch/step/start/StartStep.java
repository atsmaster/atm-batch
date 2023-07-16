package com.han.atm.batch.step.start;

import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.entity.BatterOrder;
import com.han.atm.batch.domain.service.BatterExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartStep {

    private final BatterExecutionService batterExecutionService;

    public StepStorage run(Batter batter, int batterGroupExecutionId){
        BatterExecution batterExecution = new BatterExecution(batter, batterGroupExecutionId);
        batterExecutionService.createBatterExcution(batterExecution);

        StepStorage stepStorage = new StepStorage();
        stepStorage.setBatter(batter);
        stepStorage.setBatterExecution(batterExecution);
        stepStorage.setBatterOrder(new BatterOrder());
        stepStorage.setBatterStatusCd(BatterStatusCd.DECIDE_SYMBOL);
        return stepStorage;
    }
}
