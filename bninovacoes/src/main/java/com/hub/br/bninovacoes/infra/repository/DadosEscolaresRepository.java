package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.DadosEscolares;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosEscolaresRepository extends JpaRepository<DadosEscolares, Integer> {
}
