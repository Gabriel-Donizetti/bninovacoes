package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
}
