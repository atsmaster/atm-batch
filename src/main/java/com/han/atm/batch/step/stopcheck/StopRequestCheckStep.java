package com.han.atm.batch.step.stopcheck;

import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.BatterStatusCd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StopRequestCheckStep {


    public BatterStatusCd run(StepStorage stepStorage){
        BatterStatusCd nextBatterStatusCd = null;

        switch (stepStorage.getBatterExecution().getStopRequestCd()){
            case PROFIT_STOP -> {

            }
            case NONE -> {
            }
        }

        return nextBatterStatusCd;
    }


}
