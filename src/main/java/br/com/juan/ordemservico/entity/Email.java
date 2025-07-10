package br.com.juan.ordemservico.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Email {

    @Id
    @Schema(hidden = true)
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "O campo 'melhorEmail' é obrigatório")
    @jakarta.validation.constraints.Email
    private String melhorEmail;


    private String emailOpcional;

    @ManyToOne
    @Schema(hidden = true)
    @JsonBackReference
    @JoinColumn(name = "pessoa_id", nullable = false)
     private CadastroPessoaFisica pessoa;
}
