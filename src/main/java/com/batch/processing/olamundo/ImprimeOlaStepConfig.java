package com.batch.processing.olamundo;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
public class ImprimeOlaStepConfig {

  @Bean("imprimirStep")
  public Step imprimir(JobRepository jobRepository,
      PlatformTransactionManager platformTransactionManager,
      ImprimeOlaTasklet ImprimeOlaTasklet) {
    return new StepBuilder("imprimeOlaStep", jobRepository)
        .tasklet(ImprimeOlaTasklet, platformTransactionManager)
        .build();
  }

}
