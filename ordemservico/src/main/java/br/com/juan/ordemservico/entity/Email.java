package br.com.juan.ordemservico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
public class Email {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "O Campo Email é Obrigatório")
    @jakarta.validation.constraints.Email
    private String emailPessoa;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
     private CadastroPessoaFisica pessoa;
}
