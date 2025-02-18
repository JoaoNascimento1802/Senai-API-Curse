package com.des.senai.repositories;

import com.des.senai.entities.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Integer> {
}
