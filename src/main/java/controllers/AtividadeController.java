package controllers;

import entities.Atividade;
import entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.AtividadeRepository;
import repositories.CategoriaRepository;

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
    public Atividade adicionarAtividade(@RequestBody Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    @PutMapping("/{atividadeId}/categoria/{categoriaId}")
    public String associarCategoria(@PathVariable Integer atividadeId, @PathVariable Integer categoriaId) {
        Optional<Atividade> atividadeOpt = atividadeRepository.findById(atividadeId);
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(categoriaId);

        if (atividadeOpt.isPresent() && categoriaOpt.isPresent()) {
            Atividade atividade = atividadeOpt.get();
            atividade.setCategoria(categoriaOpt.get());
            atividadeRepository.save(atividade);
            return "Categoria associada com sucesso!";
        }
        return "Atividade ou Categoria não encontrada!";
    }
}
