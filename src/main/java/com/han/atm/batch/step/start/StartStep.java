package com.han.atm.batch.step.start;

import com.han.atm.batch.domain.StepStorage;
import com.han.atm.batch.domain.code.BatterStatusCd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartStep {

    public BatterStatusCd run(){
        StepStorage stepStorage = new StepStorage();



        return null;
    }
}
