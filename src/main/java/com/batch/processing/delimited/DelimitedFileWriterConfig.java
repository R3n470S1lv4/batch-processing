package com.batch.processing.delimited;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelimitedFileWriterConfig {

  @Bean
  public ItemWriter<Pessoa> writer() {
    return items -> items.forEach(System.out::println);
  }

}
