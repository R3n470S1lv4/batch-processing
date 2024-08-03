package com.batch.processing.delimited;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelimitedFileJobConfig {

  @Bean
  public Job delimitedFileJob(JobRepository jobRepository, Step step) {
    return new JobBuilder("delimitedFileJob", jobRepository)
        .start(step)
        .incrementer(new RunIdIncrementer())
        .build();
  }

}
