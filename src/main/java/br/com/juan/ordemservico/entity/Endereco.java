package br.com.juan.ordemservico.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Endereco {


   @Id
   @Schema(hidden = true)
   @GeneratedValue
   @UuidGenerator
   private UUID id;


   @NotBlank(message = "O nome da rua é obrigatório")
   private String rua;


   private String numero;


   @Pattern(regexp = "\\d{8}", message = "CEP deve conter exatamente 8 dígitos EX:13212-290")
   @NotBlank(message = "O nome da rua é obrigatório")
   private String cep;

   @ManyToOne
   @Schema(hidden = true)
   @JoinColumn(name = "pessoa_id")
   @JsonBackReference
   private CadastroPessoaFisica pessoa;

}
