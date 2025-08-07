package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Terapeuta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerapeutaRepository extends JpaRepository<Terapeuta, String> {
}
