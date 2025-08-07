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
@Table(name = "supervisao")
@Entity(name = "supervisao")
//TODO: perguntar pro arthur oq é supervisao
public class Supervisao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipoSupervisao;

    private Dias dia;

    private LocalDateTime data;

    private Terapeuta supervisor;

    private Terapeuta supervisionado;
}
