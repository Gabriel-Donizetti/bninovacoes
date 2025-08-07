package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Supervisao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisaoRepository extends JpaRepository<Supervisao, Integer> {
}
