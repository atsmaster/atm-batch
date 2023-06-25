package com.han.atm.batch.battergroup;

import com.han.atm.batch.batter.BatterAsync;
import com.han.atm.batch.batter.BatterService;
import com.han.atm.batch.batter.domain.Batter;
import com.han.atm.batch.batter.domain.BatterExecution;
import com.han.atm.batch.batter.domain.BatterGroup;
import com.han.atm.batch.batter.domain.BatterGroupExecution;
import com.han.atm.batch.batter.repository.BatterGroupExecutionRepository;
import com.han.atm.batch.batter.repository.BatterGroupRepository;
import com.han.atm.batch.batter.repository.BatterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.plaf.ProgressBarUI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

@Component
@StepScope
@RequiredArgsConstructor
public class BatterGroupTask implements Tasklet {

    private final BatterService batterService;

    private final BatterAsync batterAsync;

    @Value("#{jobParameters['batterGroupId']}")
    private int batterGroupId;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        BatterGroupExecution batterGroupExecution = new BatterGroupExecution(batterGroupId);
        batterService.createBatterGroupExcution(batterGroupExecution);

        List<Batter> batters = batterService.findByBatterGroupId(batterGroupExecution.getBatterGroupId());

        batters.stream().forEach(batter ->{
            batterAsync.run(batter, batterGroupExecution.getBatterGroupExecutionId());
        });

        Thread.sleep(100000);

        return null;
    }

}
