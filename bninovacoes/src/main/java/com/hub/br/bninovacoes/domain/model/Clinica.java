package com.hub.br.bninovacoes.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hub.br.bninovacoes.application.admin.representation.CreateClinicaDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "clinica")
@Entity(name = "clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private Float valorConsulta;

    private boolean ativa;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Convenio> convenios;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Terapia> terapias;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Unidade> unidades;

    @OneToOne(mappedBy = "clinica", cascade = CascadeType.ALL)
    private Licenca licenca;

    public Clinica(CreateClinicaDto dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
