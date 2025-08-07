package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaRepository extends JpaRepository<Licenca, Integer> {
}
