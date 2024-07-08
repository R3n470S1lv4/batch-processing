package com.batch.processing;

import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
public class ParImparBatchConfig {

  @Bean
  public Job imprimeParImparJob(JobRepository jobRepository, Step imprimeParImparStep) {
    return new JobBuilder("imprimeParImparJob", jobRepository)
        .start(imprimeParImparStep)
        .incrementer(new RunIdIncrementer())
        .build();
  }

  @Bean
  public Step imprimeParImparStep(JobRepository jobRepository,
      PlatformTransactionManager platformTransactionManager) {
    return new StepBuilder("imprimeParImparStep", jobRepository)
        .<Integer, String>chunk(1, platformTransactionManager)
        .reader(contaAteDezReader())
        .processor(parOuImparProcessor())
        .writer(parOuImparWriter())
        .build();
  }

  private IteratorItemReader<Integer> contaAteDezReader() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 6, 7, 8, 9, 10);
    return new IteratorItemReader<>(numbers);
  }

  private FunctionItemProcessor<? super Integer, String> parOuImparProcessor() {
    return new FunctionItemProcessor<>(
        item -> item % 2 == 0 ? String.format("Item %s eh Par", item)
            : String.format("Item %s eh Impar", item));
  }

  private ItemWriter<? super String> parOuImparWriter() {
    return items -> items.forEach(System.out::println);
  }
}
