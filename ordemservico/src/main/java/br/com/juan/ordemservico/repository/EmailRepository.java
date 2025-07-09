package br.com.juan.ordemservico.repository;

import br.com.juan.ordemservico.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository  extends JpaRepository<Email, UUID> {
}
