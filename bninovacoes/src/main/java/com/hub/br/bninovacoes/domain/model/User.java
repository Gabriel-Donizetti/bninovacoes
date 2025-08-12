package com.hub.br.bninovacoes.domain.model;

import com.hub.br.bninovacoes.domain.enuns.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "users")
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User implements UserDetails {

    // -----------------Controle de acesso--------------//
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    private boolean active = true;

    private LocalDateTime criado;

    private LocalDateTime atualizado;
    // -----------------------------------------------//

    private String nome;

    private LocalDateTime dataNascimento;

    private String genero;

    private String estadoCivil;

    private String cpf;

    private String email;

    private String celular;

    @Lob
    @Column(name = "foto", length = 5000)
    private byte[] foto;

    private String nacionalidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_bancarios_id", referencedColumnName = "id")
    private DadosBancarios dadosBancarios;

    // Clinica null para super_admins
    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public abstract Collection<? extends GrantedAuthority> getAuthorities();

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @PrePersist
    @PreUpdate
    public void defineTipo() {
        if (this instanceof AdminMaster) {
            this.role = UserRole.ADMIN;
        } else if (this instanceof Funcionario) {
            this.role = UserRole.USER;
        } else if (this instanceof Paciente) {
            this.role = UserRole.USER;
        } else if (this instanceof Responsavel) {
            this.role = UserRole.USER;
        }
    }
}
