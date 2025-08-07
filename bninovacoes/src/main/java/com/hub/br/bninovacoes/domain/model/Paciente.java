package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.domain.enuns.Situacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "paciente")
@Entity(name = "paciente")
public class Paciente extends User {

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;

    private String numCarteirinha;

    private List<String> cidDiagnostico;

    private List<Responsavel> responsaveis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_escolares_id")
    private DadosEscolares dadosEscolares;

    private String nivelSuporte;

    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_PACIENTE"));
    }
}
