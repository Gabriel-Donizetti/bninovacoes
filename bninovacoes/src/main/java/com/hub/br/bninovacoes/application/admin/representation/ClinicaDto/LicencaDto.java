package com.hub.br.bninovacoes.application.admin.representation.ClinicaDto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import com.hub.br.bninovacoes.domain.enuns.TipoLicenca;

public record LicencaDto(
        @NotNull TipoLicenca tipoLicenca,
        @NotNull Float valor,
        @NotNull LocalDateTime inicio,
        @NotNull LocalDateTime fim) {
}
