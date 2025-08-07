package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Unidade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    Optional<Unidade> findByCnpj(String cnpj);
}
