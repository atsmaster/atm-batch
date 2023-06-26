package com.han.atm.batch.step.stopcheck;

import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.domain.service.BatterExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StepStopRequestCheck {

    private final BatterExecutionService batterExecutionService;

    public BatterStatusCd run(int batterExecutionId){
        BatterStatusCd nextBatterStatusCd = null;

        BatterExecution batterExecution = batterExecutionService.findById(batterExecutionId);

        switch (batterExecution.getStopRequestCd()){
            case PROFIT_STOP -> {

            }
            case NONE -> {
            }
        }

        return nextBatterStatusCd;
    }


}
