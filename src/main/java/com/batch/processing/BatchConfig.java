package com.batch.processing;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

  @Bean
  public Job ImprimeOla(JobRepository jobRepository, Step imprimeOlaStep) {
    return new JobBuilder("ImprimeOla", jobRepository)
        .start(imprimeOlaStep)
        .build();
  }

  @Bean
  public Step imprimeOlaStep(JobRepository jobRepository,
      PlatformTransactionManager platformTransactionManager) {
    return new StepBuilder("imprimeOlaStep", jobRepository)
        .tasklet((contribution, chunkContext) -> {
          System.out.println("ola, mundo!");
          return RepeatStatus.FINISHED;
        }, platformTransactionManager)
        .build();
  }

}
