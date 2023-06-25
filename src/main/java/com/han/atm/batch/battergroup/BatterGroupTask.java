package com.han.atm.batch.battergroup;

import com.han.atm.batch.batter.BatterAsync;
import com.han.atm.batch.batter.BatterService;
import com.han.atm.batch.domain.entity.Batter;
import com.han.atm.batch.domain.entity.BatterGroupExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

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
