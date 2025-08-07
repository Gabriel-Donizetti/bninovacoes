package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.domain.enuns.Periodo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "dados_escolares")
@Entity(name = "dados_escolares")
public class DadosEscolares {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nomeEscola;

    private String nomeDiretor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    private String telefone;

    private Periodo periodo;

}
