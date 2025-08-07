package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
}
