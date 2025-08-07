package com.hub.br.bninovacoes.application.admin.representation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateClinicaDto(
        @NotBlank @NotNull String nome,
        @NotNull Float valorConsulta,
        @NotNull FuncionarioDto user,
        @NotNull List<UnidadeDto> unidades,
        @NotNull LicencaDto licenca) {
}
