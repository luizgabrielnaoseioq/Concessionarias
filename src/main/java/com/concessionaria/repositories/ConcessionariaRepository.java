package com.concessionaria.repositories;

import com.concessionaria.models.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {
}
