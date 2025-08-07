package com.hub.br.bninovacoes.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "terapia")
@Entity(name = "terapia")
public class Terapia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String descicao;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;
}
