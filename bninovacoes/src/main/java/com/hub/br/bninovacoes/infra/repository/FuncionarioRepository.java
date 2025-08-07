package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Funcionario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    Optional<Funcionario> findByNumPis(String numPis);
}
