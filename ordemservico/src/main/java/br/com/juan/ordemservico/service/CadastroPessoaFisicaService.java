package br.com.juan.ordemservico.service;

import br.com.juan.ordemservico.entity.CadastroPessoaFisica;
import br.com.juan.ordemservico.entity.Email;
import br.com.juan.ordemservico.entity.Endereco;
import br.com.juan.ordemservico.repository.CadastroPessoaFisicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroPessoaFisicaService {

    @Autowired
    CadastroPessoaFisicaRepository cadastroPessoaFisicaRepository;

    public List <CadastroPessoaFisica> listarTodos() {

        return cadastroPessoaFisicaRepository.findAll();

    }

    public  CadastroPessoaFisica salvarPessoaFisica(CadastroPessoaFisica pessoaFisica){

     return  cadastroPessoaFisicaRepository.save(pessoaFisica);

    }

public Optional<CadastroPessoaFisica> buscarPorId(UUID id){

        return cadastroPessoaFisicaRepository.findById(id);

}
public void deletar(UUID id){
        cadastroPessoaFisicaRepository.deleteById(id);

}
    @Transactional
    public CadastroPessoaFisica atualizar(UUID id, CadastroPessoaFisica novaPessoa) {
        Optional<CadastroPessoaFisica> buscaPessoaFisica = this.buscarPorId(id);

        if (buscaPessoaFisica.isPresent()) {
            CadastroPessoaFisica pessoa = buscaPessoaFisica.get();


            if (novaPessoa.getNome() != null) {
                pessoa.setNome(novaPessoa.getNome());
            }

            if (novaPessoa.getCpf() != null) {
                pessoa.setCpf(novaPessoa.getCpf());
            }

            if (novaPessoa.getDataNascimento() != null) {
                pessoa.setDataNascimento(novaPessoa.getDataNascimento());
            }


            if (novaPessoa.getEmail() != null && !novaPessoa.getEmail().isEmpty()) {
                List<Email> emailsValidos = new ArrayList<>();

                for (Email email : novaPessoa.getEmail()) {
                    if (email.getMelhorEmail() != null && !email.getMelhorEmail().isBlank()) {
                        email.setPessoa(pessoa);
                        emailsValidos.add(email);
                    }
                }

                if (!emailsValidos.isEmpty()) {
                    pessoa.setEmail(emailsValidos);
                }
            }


            if (novaPessoa.getEndereco() != null && !novaPessoa.getEndereco().isEmpty()) {
                List<Endereco> enderecosValidos = new ArrayList<>();

                for (Endereco endereco : novaPessoa.getEndereco()) {
                    if (endereco.getRua() != null && !endereco.getRua().isBlank()) {
                        endereco.setPessoa(pessoa);
                        enderecosValidos.add(endereco);
                    }
                }

                if (!enderecosValidos.isEmpty()) {
                    pessoa.setEndereco(enderecosValidos);
                }
            }

            return cadastroPessoaFisicaRepository.save(pessoa);

        } else {
            throw new RuntimeException("Pessoa não encontrada com o ID: " + id);
        }
    }
}













