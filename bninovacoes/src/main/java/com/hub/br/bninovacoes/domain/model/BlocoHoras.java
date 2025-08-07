package com.hub.br.bninovacoes.domain.model;


import com.hub.br.bninovacoes.domain.enuns.Dias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "bloco_horas")
@Entity(name = "bloco_horas")
public class BlocoHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Dias diaSemana;

    private LocalTime inicio;

    private LocalTime fim;

    @ManyToOne
    @JoinColumn(name = "terapeuta_id")
    private Terapeuta terapeuta;
}
