package com.han.atm.batch.batter;


import com.han.atm.batch.domain.code.BatterStatusCd;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterExecution;
import com.han.atm.batch.step.StepStopRequestCheck;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatterAsync {
    private static final Logger logger = LoggerFactory.getLogger(BatterAsync.class);

    private final BatterService batterService;
    private final StepStopRequestCheck stepStopRequestCheck;

    @Async("asyncExecutor")
    public void run(Batter batterExecutionId, int batterGroupExecutionId) {
        BatterExecution batterExecution = new BatterExecution(batterExecutionId, batterGroupExecutionId);
        batterService.createBatterExcution(batterExecution);

        stepStopRequestCheck.run(batterExecution.getBatterExecutionId());


    }
}
