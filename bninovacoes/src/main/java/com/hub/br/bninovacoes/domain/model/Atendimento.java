package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.domain.enuns.Dias;
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
@Table(name = "atendimento")
@Entity(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "criado_por_id")
    private Funcionario criadoPor;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "terapeuta_id")
    private Terapeuta terapeuta;

    @ManyToOne
    @JoinColumn(name = "terapia_id")
    private Terapia terapia;

    @Enumerated(EnumType.STRING)
    private Dias dia;

    private LocalDateTime marcado;

    private String tipoAtendimento;//TODO:perguntar pro arthur oq é tipo atendimento

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    @ManyToOne
    @JoinColumn(name = "evolucao_id")
    private Evolucao evolucao;

    @ManyToOne
    @JoinColumn(name = "status_atendimento_id")
    private StatusAtendimento statusAtendimento;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

}
