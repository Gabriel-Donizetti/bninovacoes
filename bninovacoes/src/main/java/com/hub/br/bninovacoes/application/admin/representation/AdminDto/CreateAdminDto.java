package com.hub.br.bninovacoes.application.admin.representation.AdminDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAdminDto(

        @NotBlank @NotNull String login,
        @NotBlank @NotNull String senha,
        @NotBlank @NotNull String nome,
        @NotBlank @NotNull String departamento,
        @NotBlank @NotNull @Email String email,
        @NotBlank @NotNull String cpf,
        @NotBlank @NotNull String celular,
        @NotBlank @NotNull String genero,
        @NotBlank @NotNull String estadoCivil,
        @NotBlank @NotNull String nacionalidade

) {
}
