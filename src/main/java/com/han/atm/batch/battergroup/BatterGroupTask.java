package com.han.atm.batch.battergroup;

import com.han.atm.batch.batter.BatterAsync;
import com.han.atm.batch.batter.BatterService;
import com.han.atm.batch.batter.domain.BatterExecution;
import com.han.atm.batch.batter.repository.BatterExecutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class BatterGroupTask implements Tasklet {

    private final BatterAsync batterAsync;
    private final BatterService batterService;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<BatterExecution> batterExecutions = new ArrayList<BatterExecution>();

        IntStream.range(1, 5).forEach(i ->{
            BatterExecution batterExecution = new BatterExecution("1");
            batterService.createBatter(batterExecution);
            batterExecutions.add(batterExecution);
        });

        return null;
    }

}
