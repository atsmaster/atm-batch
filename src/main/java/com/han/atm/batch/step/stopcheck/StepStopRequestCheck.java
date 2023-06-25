package com.han.atm.batch.step.stopcheck;

import com.han.atm.batch.batter.BatterService;
import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.code.StopRequestCd;
import com.han.atm.batch.domain.entity.BatterExecution;
import kotlin.contracts.ReturnsNotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StepStopRequestCheck {

    private final BatterService batterService;

    public BatterStatusCd run(int batterExecutionId){
        BatterStatusCd nextBatterStatusCd = null;

        BatterExecution batterExecution = batterService.findBatterExcution(batterExecutionId);

        switch (batterExecution.getStopRequestCd()){
            case PROFIT_STOP -> {

            }
            case NONE -> {
            }
        }

        return nextBatterStatusCd;
    }


}
