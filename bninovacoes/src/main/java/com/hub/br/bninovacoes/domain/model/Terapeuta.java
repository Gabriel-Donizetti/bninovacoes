package com.hub.br.bninovacoes.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "terapeuta")
@Entity(name = "terapeuta")
public class Terapeuta extends Funcionario {

    @ManyToMany
    @JoinTable(
            name = "terapeuta_terapia",
            joinColumns = @JoinColumn(name = "terapeuta_id"),
            inverseJoinColumns = @JoinColumn(name = "terapia_id")
    )
    private List<Terapia> servicosPrestados;

    @ElementCollection
    private List<String> especializacoes;

    private String conselhoResponsavel;

    private String numConselho;

    private boolean statusRegistro;

    @OneToMany(mappedBy = "terapeuta", cascade = CascadeType.ALL)
    private List<BlocoHoras> disponilidade;

    @Lob
    @Column(name = "foto", length = 5000)
    private byte[] assinatura;

}
