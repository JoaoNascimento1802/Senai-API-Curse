package com.des.senai.repositories;

import com.des.senai.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
