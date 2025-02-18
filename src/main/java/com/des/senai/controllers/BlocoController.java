package com.des.senai.controllers;

import com.des.senai.entities.Atividade;
import com.des.senai.entities.Bloco;
import com.des.senai.repositories.AtividadeRepository;
import com.des.senai.repositories.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blocos")
public class BlocoController {

    @Autowired
    private BlocoRepository blocoRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @GetMapping
    public List<Bloco> listarBlocos() {
        return blocoRepository.findAll();
    }

    @PostMapping("/{atividadeId}")
    public ResponseEntity<String> adicionarBloco(@PathVariable Integer atividadeId, @RequestBody Bloco bloco) {
        Optional<Atividade> atividadeOpt = atividadeRepository.findById(atividadeId);
        if (atividadeOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Atividade não encontrada!");
        }

        bloco.setAtividade(atividadeOpt.get());
        blocoRepository.save(bloco);
        return ResponseEntity.ok("Bloco cadastrado com sucesso!");
    }
}
