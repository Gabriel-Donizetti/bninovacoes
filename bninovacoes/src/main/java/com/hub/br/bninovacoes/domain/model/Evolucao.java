package com.hub.br.bninovacoes.domain.model;


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
@Table(name = "evolucao")
@Entity(name = "evolucao")
public class Evolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime data;

    private String observacoes;

    private Terapeuta terapeuta;

    private Paciente paciente;
}
