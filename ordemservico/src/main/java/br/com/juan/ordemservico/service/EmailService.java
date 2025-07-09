package br.com.juan.ordemservico.service;

import br.com.juan.ordemservico.entity.Email;
import br.com.juan.ordemservico.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {


    @Autowired
    private EmailRepository emailRepository;

    public List<Email> listarTodosEmails() {
        return emailRepository.findAll();
    }

    public Optional<Email> buscarPorId(UUID id) {
        return emailRepository.findById(id);
    }

    public Email salvarEmails(Email email) {
        return emailRepository.save(email);
    }

    public Email atualizarEmails(UUID id, Email novoEmail) {
        Optional<Email> emailExistente = emailRepository.findById(id);

        if (emailExistente.isPresent()) {
            Email email = emailExistente.get();

            if (novoEmail.getMelhorEmail() != null) {
                email.setMelhorEmail(novoEmail.getMelhorEmail());
            }

            return emailRepository.save(email);
        } else {
            throw new RuntimeException("Email não encontrado com o ID: " + id);
        }
    }

    public void deletarEmail(UUID id) {
        emailRepository.deleteById(id);
    }


















}
