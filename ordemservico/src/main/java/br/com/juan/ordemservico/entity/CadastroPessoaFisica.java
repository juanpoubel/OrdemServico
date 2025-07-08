package br.com.juan.ordemservico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class CadastroPessoaFisica{

 @Id
 @GeneratedValue
 @UuidGenerator
 private UUID id;

 @NotBlank(message = "Nome é um campo Obrigatório")
 @Size(min = 3, max = 100, message = "Digite um nome com no mínimo 3 caracteres e na máximo 100")
 private String nome;

 @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true )
 private List<Endereco> endereco;

 @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Email> email;

 @NotNull(message = "O campo data de nascimento é obrigatório")
 @Past
 private LocalDate dataNascimento;

@NotBlank(message = "O campo CPF é obrigatório")
 private  String cpf;

}
