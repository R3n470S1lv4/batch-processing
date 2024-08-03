package com.batch.processing.delimited;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
@Getter
@Setter
@ToString
public class Pessoa {

  @NotBlank
  private String nome;
  @NotBlank
  @Size(max = 5)
  private String sobrenome;
  @NotNull
  private LocalDate dataNacimento;

  public void setDataNacimento(String dataNacimento) {
    this.dataNacimento = LocalDate.parse(dataNacimento);
  }
}
