package com.hub.br.bninovacoes.infra.security.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.hub.br.bninovacoes.domain.model.User;
import com.hub.br.bninovacoes.infra.repository.UserRepository;
import com.hub.br.bninovacoes.infra.security.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDetailsService userDetailsService() {
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String email) {
        Optional<User> user = userRepository.findByEmailOrLogin(email);
        if (user.isEmpty()) {
          throw new RuntimeException("User not found: " + email);
        }

        return user.get();
      }
    };
  }
}