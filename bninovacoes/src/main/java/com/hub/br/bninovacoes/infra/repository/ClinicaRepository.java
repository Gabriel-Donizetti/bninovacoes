package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Clinica;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {

    Optional<Clinica> findByNome(String nome);

}
