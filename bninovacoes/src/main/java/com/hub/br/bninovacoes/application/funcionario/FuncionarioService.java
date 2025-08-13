package com.hub.br.bninovacoes.application.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hub.br.bninovacoes.application.admin.representation.ClinicaDto.FuncionarioDto;
import com.hub.br.bninovacoes.domain.model.Funcionario;
import com.hub.br.bninovacoes.infra.repository.FuncionarioRepository;
import com.hub.br.bninovacoes.infra.repository.UserRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UserRepository userRepository;

    public String criarfuncionario(FuncionarioDto dto) {
        if (userRepository.findByEmailOrLogin(dto.login()).isPresent()) {
            throw new IllegalArgumentException("Login: " + dto.login() + " já existe");
        }
        if (userRepository.findByEmailOrLogin(dto.email()).isPresent()) {
            throw new IllegalArgumentException("Email: " + dto.email() + " já existe");
        }
        if (userRepository.findByCpf(dto.cpf()).isPresent()) {
            throw new IllegalArgumentException("Cpf " + dto.cpf() + " já existe");
        }
        if (funcionarioRepository.findByNumPis(dto.numPis()).isPresent()) {
            throw new IllegalArgumentException("Pis " + dto.numPis() + " já existe");

        }

        Funcionario funcionario = new Funcionario(dto);
        funcionario.setClinica(null);
        funcionarioRepository.save(funcionario);
        return funcionario.getId();
    }

}
