package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.BlocoHoras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocoHorasRepository extends JpaRepository<BlocoHoras, Integer> {
}
