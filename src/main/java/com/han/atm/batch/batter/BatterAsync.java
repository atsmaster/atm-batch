package com.han.atm.batch.batter;


import com.han.atm.batch.batter.domain.Batter;
import com.han.atm.batch.batter.domain.BatterExecution;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatterAsync {
    private static final Logger logger = LoggerFactory.getLogger(BatterAsync.class);

    private final BatterService batterService;

    @Async("asyncExecutor")
    public void run(Batter batterExecutionId, int batterGroupExecutionId) {

        batterService.createBatterExcution(new BatterExecution(batterExecutionId, batterGroupExecutionId));
    }
}
