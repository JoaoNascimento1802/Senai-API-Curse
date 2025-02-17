package controllers;

import entities.Atividade;
import entities.Bloco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.AtividadeRepository;
import repositories.BlocoRepository;

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
    public String adicionarBloco(@PathVariable Integer atividadeId, @RequestBody Bloco bloco) {
        Optional<Atividade> atividadeOpt = atividadeRepository.findById(atividadeId);
        if (atividadeOpt.isPresent()) {
            bloco.setAtividade(atividadeOpt.get());
            blocoRepository.save(bloco);
            return "Bloco cadastrado com sucesso!";
        }
        return "Atividade não encontrada!";
    }
}
