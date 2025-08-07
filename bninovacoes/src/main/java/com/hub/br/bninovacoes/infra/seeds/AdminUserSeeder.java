package com.hub.br.bninovacoes.infra.seeds;

import com.hub.br.bninovacoes.domain.model.AdminMaster;
import com.hub.br.bninovacoes.infra.repository.AdminMasterRepository;
import com.hub.br.bninovacoes.infra.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AdminUserSeeder implements CommandLineRunner {

    private final AdminMasterRepository adminMasterRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        createAdminMaster();
    }

    private void createAdminMaster() {

        if (userRepository.findByEmail("admin@hub.com.br").isPresent()) {
            return;
        }

        AdminMaster admin = new AdminMaster();
        admin.setLogin("admin@hub.com.br");
        admin.setSenha(passwordEncoder.encode("admin"));
        admin.setNome("Administrador Master");
        admin.setDepartamento("TI");
        admin.setEmail("admin@hub.com.br");
        admin.setCpf("000.000.000-00");
        admin.setCelular("11999999999");
        admin.setGenero("Outro");
        admin.setEstadoCivil("Solteiro");
        admin.setNacionalidade("Brasileiro");
        admin.setCriado(LocalDateTime.now());
        admin.setAtualizado(LocalDateTime.now());
        admin.setActive(true);

        adminMasterRepository.save(admin);
        System.out.println("✅ Usuário admin criado com sucesso.");
    }

}
