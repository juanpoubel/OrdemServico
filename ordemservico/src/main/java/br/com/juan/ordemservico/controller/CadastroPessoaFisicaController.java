package br.com.juan.ordemservico.controller;


import br.com.juan.ordemservico.entity.CadastroPessoaFisica;
import br.com.juan.ordemservico.service.CadastroPessoaFisicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/cadastro")
public class CadastroPessoaFisicaController {

    @Autowired
    private CadastroPessoaFisicaService service;

    @GetMapping("/listarCadastros")
    public ResponseEntity<List<CadastroPessoaFisica>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/buscarCadastroPorId/{id}")
    public ResponseEntity<CadastroPessoaFisica> buscarPorId(@PathVariable UUID id) {
        Optional<CadastroPessoaFisica> pessoa = service.buscarPorId(id);
        return pessoa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/salvarCadastroPessoaFisica")
    public ResponseEntity<CadastroPessoaFisica> salvar(@Valid @RequestBody CadastroPessoaFisica pessoa) {


        if (pessoa.getEmail() != null) {
            pessoa.getEmail().forEach(e -> e.setPessoa(pessoa));
        }

        if (pessoa.getEndereco() != null) {
            pessoa.getEndereco().forEach(e -> e.setPessoa(pessoa));
        }
        return ResponseEntity.ok(service.salvarPessoaFisica(pessoa));
    }

    @PutMapping("/atualizaCadastroPessoaFisica/{id}")
    public ResponseEntity<CadastroPessoaFisica> atualizar(@PathVariable UUID id, @RequestBody CadastroPessoaFisica novaPessoa) {
        // Garantir que os relacionamentos estejam consistentes
        if (novaPessoa.getEmail() != null && !novaPessoa.getEmail().isEmpty()) {
            novaPessoa.setEmail(novaPessoa.getEmail());
        }
        if (novaPessoa.getEndereco() != null && !novaPessoa.getEmail().isEmpty()) {
            novaPessoa.getEndereco().forEach(e -> e.setPessoa(novaPessoa));
        }
        return ResponseEntity.ok(service.atualizar(id, novaPessoa));
    }

    @DeleteMapping("/deletaCadastroPessoaFisica/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }























}
