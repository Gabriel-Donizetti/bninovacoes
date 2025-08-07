package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.application.admin.representation.FuncionarioDto;
import com.hub.br.bninovacoes.domain.enuns.Funcao;
import com.hub.br.bninovacoes.domain.enuns.Situacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends User {

    private String regimeContrato;

    private Float salarioBase;

    private String numPis;

    private String tituloEleitor;

    private LocalDate dataAdmissao;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Beneficios> beneficios;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "funcionario_funcoes", joinColumns = @JoinColumn(name = "funcionario_id"))
    @Column(name = "funcao")
    private Set<Funcao> funcoes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.funcoes.stream()
                .map(funcao -> new SimpleGrantedAuthority("ROLE_FUNCIONARIO"))
                .toList();
    }

    public Funcionario(FuncionarioDto dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
