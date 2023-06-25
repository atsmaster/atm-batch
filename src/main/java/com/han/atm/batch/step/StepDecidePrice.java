package com.han.atm.batch.step;

import com.han.atm.batch.batter.BatterService;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.BatterExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StepDecidePrice {

    private final BatterService batterService;

    public BatterStatusCd run(int batterExecutionId){
        BatterStatusCd nextBatterStatusCd = null;

        BatterExecution batterExecution = batterService.findBatterExcution(batterExecutionId);

        switch (batterExecution.getDecidePriceWaitCd()){
            case NONE -> {

            }
            case LACK -> {
            }
        }
        return null;
    }
}
