package com.hub.br.bninovacoes.domain.enuns;

public enum UserRole {
    ADMIN_MASTER("amin_master"),
    FUNCIONARIO("funcionario"),
    PACIENTE("paciente"),
    RESPONSAVEL("responsavel");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}