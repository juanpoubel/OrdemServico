package br.com.juan.ordemservico.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class CadastroPessoaFisica{

 @Id
 @Schema(hidden = true)
 @GeneratedValue
 @UuidGenerator
 private UUID id;


 @Size(min = 3, max = 100, message = "Digite um nome com no mínimo 3 caracteres e na máximo 100")
 @NotBlank(message = "O campo nome é obrigatório")
 private String nome;

 @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true )
 @JsonManagedReference
 private List<Endereco> endereco;

 @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
 @JsonManagedReference
 private List<Email> email;


 @Past
 private LocalDate dataNascimento;

 @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 caracteres")
 private  String cpf;

}
