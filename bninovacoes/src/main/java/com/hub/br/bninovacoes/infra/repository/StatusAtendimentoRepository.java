package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.StatusAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusAtendimentoRepository extends JpaRepository<StatusAtendimento, Integer> {
}
