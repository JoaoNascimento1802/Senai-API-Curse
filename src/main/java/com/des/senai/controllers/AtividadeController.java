package com.des.senai.controllers;

import com.des.senai.entities.Atividade;
import com.des.senai.entities.Categoria;
import com.des.senai.repositories.AtividadeRepository;
import com.des.senai.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Atividade> adicionarAtividade(@RequestBody Atividade atividade) {
        Atividade novaAtividade = atividadeRepository.save(atividade);
        return ResponseEntity.ok(novaAtividade);
    }

    @PutMapping("/{atividadeId}/categoria/{categoriaId}")
    public ResponseEntity<String> associarCategoria(@PathVariable Integer atividadeId, @PathVariable Integer categoriaId) {
        Optional<Atividade> atividadeOpt = atividadeRepository.findById(atividadeId);
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(categoriaId);

        if (atividadeOpt.isEmpty() || categoriaOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Atividade ou Categoria não encontrada!");
        }

        Atividade atividade = atividadeOpt.get();
        atividade.setCategoria(categoriaOpt.get());
        atividadeRepository.save(atividade);

        return ResponseEntity.ok("Categoria associada com sucesso!");
    }
}
