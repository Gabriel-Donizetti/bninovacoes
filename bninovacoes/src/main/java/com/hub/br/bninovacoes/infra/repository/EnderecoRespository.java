package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRespository extends JpaRepository<Endereco, Integer> {
}
