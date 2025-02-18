package com.des.senai.controllers;

import com.des.senai.entities.Atividade;
import com.des.senai.entities.Participante;
import com.des.senai.repositories.AtividadeRepository;
import com.des.senai.repositories.ParticipanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @GetMapping
    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Participante> adicionarParticipante(@RequestBody Participante participante) {
        Participante novoParticipante = participanteRepository.save(participante);
        return ResponseEntity.ok(novoParticipante);
    }

    @Transactional
    @PostMapping("/{participanteId}/inscrever/{atividadeId}")
    public ResponseEntity<String> inscreverParticipante(@PathVariable Integer participanteId, @PathVariable Integer atividadeId) {
        Optional<Participante> participanteOpt = participanteRepository.findById(participanteId);
        Optional<Atividade> atividadeOpt = atividadeRepository.findById(atividadeId);

        if (participanteOpt.isEmpty() || atividadeOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Participante ou atividade não encontrada!");
        }

        Participante participante = participanteOpt.get();
        Atividade atividade = atividadeOpt.get();

        // Adiciona a relação nos dois lados
        participante.getAtividades().add(atividade);
        atividade.getParticipantes().add(participante);

        participanteRepository.save(participante);
        atividadeRepository.save(atividade);

        return ResponseEntity.ok("Inscrição realizada com sucesso!");
    }
}
