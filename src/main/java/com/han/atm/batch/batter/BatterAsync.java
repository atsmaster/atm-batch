package com.han.atm.batch.batter;


import com.han.atm.batch.batter.domain.BatterExecution;
import com.han.atm.batch.batter.repository.BatterExecutionRepository;
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

    private final BatterExecutionRepository batterExecutionRepository;
    @Async("asyncExecutor")
    public void run(String batterExecutionId) {
        Optional<BatterExecution> batterExecution = batterExecutionRepository.findById(batterExecutionId);
        BatterExecution b = batterExecution.orElseThrow();
        b.setBatterStatusCd("GG");
        batterExecutionRepository.save(b);
    }
}
