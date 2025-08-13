package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);

    @Query("SELECT u FROM users u WHERE u.email = :value OR u.login = :value")
    Optional<User> findByEmailOrLogin(@Param("value") String value);

    Optional<User> findByCpf(String cpf);
}
