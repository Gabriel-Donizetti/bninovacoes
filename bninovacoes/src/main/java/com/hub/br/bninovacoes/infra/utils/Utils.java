package com.hub.br.bninovacoes.infra.utils;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.hub.br.bninovacoes.domain.model.Clinica;
import com.hub.br.bninovacoes.infra.repository.ClinicaRepository;

@Component
public class Utils {

    @Autowired
    private ClinicaRepository clinicaRepository;

    public Clinica getCurrentClinica() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof Map<?, ?> details) {
            Object clinicaId = details.get("clinica");
            if (clinicaId instanceof Integer) {
                return clinicaRepository.findById((Integer) clinicaId).orElse(null);
            }
        }
        return null;
    }
}
