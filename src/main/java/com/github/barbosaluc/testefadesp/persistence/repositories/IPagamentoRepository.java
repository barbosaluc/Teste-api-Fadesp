package com.github.barbosaluc.testefadesp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.barbosaluc.testefadesp.domain.entities.PagamentoEntity;

@Repository
public interface IPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
    
}
