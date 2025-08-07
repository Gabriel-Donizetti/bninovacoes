package com.hub.br.bninovacoes.application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hub.br.bninovacoes.application.auth.representation.AuthDto;
import com.hub.br.bninovacoes.domain.model.User;
import com.hub.br.bninovacoes.infra.repository.UserRepository;
import com.hub.br.bninovacoes.infra.security.TokenService;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public String login(AuthDto dto) {

        User user = userRepository.findByEmail(dto.login())
                .orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas"));

        if (!passwordEncoder.matches(dto.senha(), user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return tokenService.generateToken(user);
    }

}
