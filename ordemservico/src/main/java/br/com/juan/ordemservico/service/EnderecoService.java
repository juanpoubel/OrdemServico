package br.com.juan.ordemservico.service;

import br.com.juan.ordemservico.entity.Endereco;
import br.com.juan.ordemservico.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Endereco> listarTodosEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(UUID id) {
        return enderecoRepository.findById(id);
    }

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(UUID id, Endereco novoEndereco) {
        Optional<Endereco> enderecoExistente = enderecoRepository.findById(id);

        if (enderecoExistente.isPresent()) {
            Endereco endereco = enderecoExistente.get();

            if (novoEndereco.getRua() != null) {
                endereco.setRua(novoEndereco.getRua());
            }

            if (novoEndereco.getNumero() != null) {
                endereco.setNumero(novoEndereco.getNumero());
            }

            if (novoEndereco.getCep() != null) {
                endereco.setCep(novoEndereco.getCep());
            }

            return enderecoRepository.save(endereco);
        } else {
            throw new RuntimeException("Endereço não encontrado com o ID: " + id);
        }
    }

    public void deletarEndereco(UUID id) {
        enderecoRepository.deleteById(id);
    }











}
