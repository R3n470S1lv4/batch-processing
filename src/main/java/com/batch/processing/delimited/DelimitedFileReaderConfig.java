package com.batch.processing.delimited;

import com.batch.processing.delimited.Pessoa.Fields;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class DelimitedFileReaderConfig {

  @StepScope
  @Bean
  public FlatFileItemReader<Pessoa> delimitedFileReader() {

    ClassPathResource resource = new ClassPathResource("pessoas.txt");
    return new FlatFileItemReaderBuilder<Pessoa>()
        .name("delimitedFileReader")
        .resource(resource)
        .delimited()
        .delimiter(";")
        .names(Fields.nome, Fields.sobrenome, Fields.dataNacimento)
        .targetType(Pessoa.class)
        .build();
  }
}
