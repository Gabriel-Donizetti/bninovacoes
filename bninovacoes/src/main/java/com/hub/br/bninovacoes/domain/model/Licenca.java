package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.domain.enuns.TipoLicenca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "licenca")
@Entity(name = "licenca")
public class Licenca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private TipoLicenca tipoLicenca;

    private Float valor;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    private boolean ativa;

    @OneToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;
}
