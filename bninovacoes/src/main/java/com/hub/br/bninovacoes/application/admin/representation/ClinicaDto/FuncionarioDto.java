package com.hub.br.bninovacoes.application.admin.representation.ClinicaDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.hub.br.bninovacoes.domain.enuns.Situacao;
import com.hub.br.bninovacoes.domain.model.Beneficios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioDto(

                // Autenticação de usuario
                @NotBlank @NotNull String nome,
                @NotBlank @NotNull String login,
                @NotBlank @NotNull String senha,
                // Infos gerais
                @NotNull LocalDateTime dataNascimento,
                @NotBlank @NotNull String genero,
                @NotBlank @NotNull String estadoCivil,
                @NotBlank @NotNull String cpf,
                @NotBlank @NotNull @Email String email,
                @NotBlank @NotNull String celular,
                @NotBlank @NotNull String nacionalidade,
                // Endereço
                @NotBlank @NotNull String estado,
                @NotBlank @NotNull String cidade,
                @NotBlank @NotNull String rua,
                @NotNull Integer num,
                @NotBlank @NotNull String complemento,
                // Dados bancarios
                String banco,
                Number agencia,
                Number contaCorrente,
                // Funcionario
                @NotBlank @NotNull String regimeContrato,
                @NotNull Float salarioBase,
                @NotBlank @NotNull String numPis,
                @NotBlank @NotNull String tituloEleitor,
                @NotNull LocalDate dataAdmissao,
                @NotNull List<Beneficios> beneficios,
                @NotNull Situacao situacao) {
}
