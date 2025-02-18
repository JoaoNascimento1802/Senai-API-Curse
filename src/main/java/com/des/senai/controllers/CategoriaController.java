package com.des.senai.controllers;

import com.des.senai.entities.Categoria;
import com.des.senai.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(novaCategoria);
    }
}
