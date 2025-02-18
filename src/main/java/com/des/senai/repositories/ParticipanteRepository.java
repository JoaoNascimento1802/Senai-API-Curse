package com.des.senai.repositories;

import com.des.senai.entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante,Integer> {
}
