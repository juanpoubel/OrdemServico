package br.com.juan.ordemservico.repository;

import br.com.juan.ordemservico.entity.CadastroPessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CadastroPessoaFisicaRepository  extends JpaRepository<CadastroPessoaFisica, UUID> {
}
