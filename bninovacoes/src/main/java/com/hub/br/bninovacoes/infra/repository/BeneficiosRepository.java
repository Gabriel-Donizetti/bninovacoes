package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Beneficios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiosRepository extends JpaRepository<Beneficios, Integer> {
}
