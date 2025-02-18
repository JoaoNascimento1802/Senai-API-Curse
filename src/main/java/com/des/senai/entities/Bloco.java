package com.des.senai.entities;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Instant inicio;
    private Instant fim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    public Bloco() {
    }

    public Bloco(int id, Instant inicio, Instant fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Bloco(int id, Instant inicio, Instant fim, Atividade atividade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.atividade = atividade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Instant getInicio() { return inicio; }
    public void setInicio(Instant inicio) { this.inicio = inicio; }

    public Instant getFim() { return fim; }
    public void setFim(Instant fim) { this.fim = fim; }

    public Atividade getAtividade() { return atividade; }
    public void setAtividade(Atividade atividade) { this.atividade = atividade; }
}
