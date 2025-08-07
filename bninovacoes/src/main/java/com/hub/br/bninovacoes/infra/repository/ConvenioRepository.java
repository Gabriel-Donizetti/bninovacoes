package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {
}
