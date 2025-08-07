package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.domain.enuns.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "status_atendimento")
@Entity(name = "status_atendimento")
public class StatusAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Status status;

    private String motivo;
}
