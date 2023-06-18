package com.han.atm.batch.battergroup;



import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty( name = "spring.batch.job.names", havingValue = BatterGroupJob.JOB_NAME)
public class BatterGroupJob {
    public static final String JOB_NAME = "batterGroup";

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job job() throws Exception {
        return jobBuilderFactory.get(JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .start(batterGroupStep())
                .build();
    }


    @Bean
    @JobScope
    public Step batterGroupStep() throws Exception {
        return stepBuilderFactory.get("batterGroupStep")
                .tasklet(new BatterGroupTask())
                .build();
    }
}
