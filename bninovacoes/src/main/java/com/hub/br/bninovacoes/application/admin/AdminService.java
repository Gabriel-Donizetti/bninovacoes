package com.hub.br.bninovacoes.application.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hub.br.bninovacoes.application.admin.representation.CreateClinicaDto;
import com.hub.br.bninovacoes.domain.model.Clinica;
import com.hub.br.bninovacoes.domain.model.Funcionario;
import com.hub.br.bninovacoes.domain.model.Licenca;
import com.hub.br.bninovacoes.domain.model.Unidade;
import com.hub.br.bninovacoes.infra.repository.ClinicaRepository;
import com.hub.br.bninovacoes.infra.repository.FuncionarioRepository;
import com.hub.br.bninovacoes.infra.repository.UnidadeRepository;
import com.hub.br.bninovacoes.infra.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public String create(CreateClinicaDto dto) throws Exception {

        if (clinicaRepository.findByNome(dto.nome()).isPresent()) {
            throw new IllegalArgumentException("Essa clínica já existe");
        }

        // Verifica se o usuário já existe
        if (userRepository.findByEmail(dto.user().login()) != null) {
            throw new IllegalArgumentException("Usuário com email: " + dto.user().login() + " já existe");
        }

        // Verifica se o funcionário já existe
        if (funcionarioRepository.findByNumPis(dto.user().numPis()) != null) {
            throw new IllegalArgumentException("Funcionário com PIS: " + dto.user().numPis() + " já existe");
        }

        // Cria clínica
        Clinica clinica = new Clinica();
        clinica.setNome(dto.nome());
        clinica.setValorConsulta(dto.valorConsulta());
        clinica.setAtiva(true);

        // Cria licença
        Licenca licenca = new Licenca();
        licenca.setAtiva(true);
        licenca.setTipoLicenca(null);
        licenca.setInicio(dto.licenca().inicio());
        licenca.setFim(dto.licenca().fim());
        licenca.setValor(dto.licenca().valor());
        licenca.setClinica(clinica);
        clinica.setLicenca(licenca);

        // Cria funcionário (admin da clínica)
        Funcionario funcionario = new Funcionario(dto.user());
        funcionario.setClinica(clinica);
        clinica.setFuncionarios(List.of(funcionario));

        // Converte unidades
        List<Unidade> unidades = dto.unidades().stream().map(unidadeDto -> {
            if (unidadeRepository.findByCnpj(unidadeDto.cnpj()).isPresent()) {
                throw new IllegalArgumentException("Unidade com CNPJ: " + unidadeDto.cnpj() + " já cadastrada");
            }
            Unidade unidade = new Unidade();
            unidade.setCnpj(unidadeDto.cnpj());
            unidade.setAbreAs(unidadeDto.abreAs());
            unidade.setFechaAs(unidadeDto.fechaAs());
            unidade.setDuracaoAtendimento(unidadeDto.duracaoAtendimento());
            unidade.setEndereco(unidadeDto.endereco());
            unidade.setDiasFuncionamento(unidadeDto.diasFuncionamento());
            unidade.setAtiva(unidadeDto.ativa());
            unidade.setMatriz(unidadeDto.matriz());
            unidade.setClinica(clinica);
            return unidade;
        }).collect(Collectors.toList());

        clinica.setUnidades(unidades);

        clinicaRepository.save(clinica);

        return "Clínica criada com sucesso";
    }

}
