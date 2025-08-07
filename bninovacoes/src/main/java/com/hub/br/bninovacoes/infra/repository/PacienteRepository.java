package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
