package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.DadosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Integer> {
}
