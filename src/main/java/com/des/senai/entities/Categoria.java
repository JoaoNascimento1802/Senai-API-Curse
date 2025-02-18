package com.des.senai.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Atividade> atividades = new HashSet<>();

    public Categoria() {
    }

    public Categoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Categoria(int id, String descricao, Set<Atividade> atividades) {
        this.id = id;
        this.descricao = descricao;
        this.atividades = (atividades != null) ? atividades : new HashSet<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Set<Atividade> getAtividades() { return atividades; }
    public void setAtividades(Set<Atividade> atividades) { this.atividades = atividades; }
}
