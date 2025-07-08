package br.com.juan.ordemservico.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
public class Endereco {


   @Id
   @GeneratedValue
   @UuidGenerator
   private UUID id;

   @NotBlank
   private String rua;

   @NotBlank
   private String numero;

   @NotBlank
   @Pattern(regexp = "\\d{8}", message = "CEP deve conter exatamente 8 dígitos EX:13212-290")
   private String cep;

   @ManyToOne
   @JoinColumn(name = "pessoa_id", nullable = false)
   private CadastroPessoaFisica pessoa;

}
