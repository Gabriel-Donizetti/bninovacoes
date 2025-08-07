package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Terapia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerapiaRepository extends JpaRepository<Terapia, Integer> {
}
