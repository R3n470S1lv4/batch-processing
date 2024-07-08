package com.batch.processing.olamundo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OlaMundoJobConfig {

  @Bean
  public Job imprimeOla(JobRepository jobRepository, Step imprimeOlaStep) {
    return new JobBuilder("imprimeOla", jobRepository)
        .start(imprimeOlaStep)
        .incrementer(new RunIdIncrementer())
        .build();
  }

}
