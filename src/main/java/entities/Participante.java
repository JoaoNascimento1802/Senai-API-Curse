package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "participante_atividade",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "atividade_id")
    )
    private Set<Atividade> atividades = new HashSet<>();

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public Participante(int id, String nome, String email, Set<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.atividades = atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Participante() {
    }

    public Participante(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
