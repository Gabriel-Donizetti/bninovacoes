package com.hub.br.bninovacoes.application.admin.representation;

import com.hub.br.bninovacoes.domain.enuns.Dias;
import com.hub.br.bninovacoes.domain.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

public record UnidadeDto(
        @NotBlank String cnpj,
        @NotNull LocalTime abreAs,
        @NotNull LocalTime fechaAs,
        @NotNull Integer duracaoAtendimento,
        @NotNull Endereco endereco,
        @NotNull List<Dias> diasFuncionamento,
        boolean ativa,
        boolean matriz) {
}