package br.com.juan.ordemservico.service;

import br.com.juan.ordemservico.entity.CadastroPessoaFisica;
import br.com.juan.ordemservico.repository.CadastroPessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
//public CadastroPessoaFisica atualizar(UUID id, CadastroPessoaFisica novaPessoa){
//    Optional<CadastroPessoaFisica> buscaPessoaFisica = this.buscarPorId(id);
//
//    if (buscaPessoaFisica.isPresent()) {
//        CadastroPessoaFisica pessoa = buscaPessoaFisica.get();
//
////        if (novaPessoa. != null) {
////            pessoa.setNome(novaPessoa.getNome());
////        }
////
////        if (novaPessoa.getCpf() != null) {
////            pessoa.setCpf(novaPessoa.getCpf());
////        }
////
////        if (novaPessoa.getDataNascimento() != null) {
////            pessoa.setDataNascimento(novaPessoa.getDataNascimento());
////        }
////
////        if (novaPessoa.getEmail() != null && !novaPessoa.getEmail().isEmpty()) {
////            pessoa.setEmail(novaPessoa.getEmail());
////        }
////
////        if (novaPessoa.getEndereco() != null && !novaPessoa.getEndereco().isEmpty()) {
////            pessoa.setEndereco(novaPessoa.getEndereco());
////        }
////
////        return repository.save(pessoa);
//    } else {
//        throw new RuntimeException("Pessoa não encontrada com o ID: " + id);
//    }









}
