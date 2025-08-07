package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvolucaoRepository extends JpaRepository<Evolucao, Integer> {
}
