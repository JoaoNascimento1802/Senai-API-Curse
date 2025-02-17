package controllers;

import entities.Atividade;
import entities.Participante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.AtividadeRepository;
import repositories.ParticipanteRepository;

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
    public Participante adicionarParticipante(@RequestBody Participante participante) {
        return participanteRepository.save(participante);
    }

    @PostMapping("/{participanteId}/inscrever/{atividadeId}")
    public String inscreverParticipante(@PathVariable Integer participanteId, @PathVariable Integer atividadeId) {
        Optional<Participante> participanteOpt = participanteRepository.findById(participanteId);
        Optional<Atividade> atividadeOpt = atividadeRepository.findById(atividadeId);

        if (participanteOpt.isPresent() && atividadeOpt.isPresent()) {
            Participante participante = participanteOpt.get();
            Atividade atividade = atividadeOpt.get();

            participante.getAtividades().add(atividade);
            participanteRepository.save(participante);
            return "Inscrição realizada com sucesso!";
        }
        return "Participante ou atividade não encontrada!";
    }
}
