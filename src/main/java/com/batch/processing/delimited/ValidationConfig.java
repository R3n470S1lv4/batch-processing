package com.batch.processing.delimited;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {

  @Bean
  public ItemProcessor<Pessoa, Pessoa> validate() {
//    BeanValidatingItemProcessor<Pessoa> validator = new BeanValidatingItemProcessor<>();
    ValidatingItemProcessor<Pessoa> validator = new ValidatingItemProcessor<>();
    validator.setValidator(customValidator());

    return validator;
  }

  private Validator<? super Pessoa> customValidator() {
    return new Validator<Pessoa>() {
      @Override
      public void validate(Pessoa value) throws ValidationException {
        if (value.getSobrenome().isBlank()) {
          throw new ValidationException("Sobrenome cant be null");
        }
      }
    };
  }


}
