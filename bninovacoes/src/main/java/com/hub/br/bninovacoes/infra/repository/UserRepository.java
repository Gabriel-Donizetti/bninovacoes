package com.hub.br.bninovacoes.infra.repository;

import com.hub.br.bninovacoes.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);

    Optional<User> findByEmail(String email);
}
