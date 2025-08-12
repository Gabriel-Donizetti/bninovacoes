package com.hub.br.bninovacoes.application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.hub.br.bninovacoes.application.auth.representation.AuthDto;
import com.hub.br.bninovacoes.application.auth.representation.LoginResDto;
import com.hub.br.bninovacoes.application.utils.ErrorDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> postMethodName(@RequestBody @Valid AuthDto dto) {
        try {
            return ResponseEntity.ok(new LoginResDto(service.login(dto)));

        } catch (Exception e) {
            return ResponseEntity.status(401).body(new ErrorDto(e.getMessage()));
        }
    }

}
