package com.batch.processing.delimited;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DelimitedFileReaderStepConfig {

  @Bean
  public Step readerStep(JobRepository jobRepository,
      PlatformTransactionManager platformTransactionManager,
      ItemReader<Pessoa> delimitedFileReader,
      ItemWriter<? super Pessoa> delimitedFileWriterConfig,
      ItemProcessor<Pessoa, Pessoa> validationConfig) {
    return new StepBuilder("readerStep", jobRepository)
        .<Pessoa, Pessoa>chunk(1, platformTransactionManager)
        .reader(delimitedFileReader)
        .processor(validationConfig)
        .writer(delimitedFileWriterConfig)
        .build();
  }
}
