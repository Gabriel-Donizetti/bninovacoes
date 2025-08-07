package com.hub.br.bninovacoes.application.auth.representation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthDto(

        @NotBlank @NotNull String login,
        @NotBlank @NotNull String senha

) {

}
