package com.hub.br.bninovacoes.application.admin;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hub.br.bninovacoes.application.admin.representation.AdminDto.CreateAdminDto;
import com.hub.br.bninovacoes.application.admin.representation.ClinicaDto.CreateClinicaDto;
import com.hub.br.bninovacoes.domain.model.AdminMaster;
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
    public Integer createClinica(CreateClinicaDto dto) throws Exception {

        if (clinicaRepository.findByNome(dto.nome()).isPresent()) {
            throw new IllegalArgumentException("Essa clínica já existe");
        }

        if (userRepository.findByEmailOrLogin(dto.user().login()).isPresent()) {
            throw new IllegalArgumentException("Usuário com email: " + dto.user().login() + " já existe");
        }

        if (funcionarioRepository.findByNumPis(dto.user().numPis()).isPresent()) {
            throw new IllegalArgumentException("Funcionário com PIS: " + dto.user().numPis() + " já existe");
        }

        Clinica clinica = new Clinica();
        clinica.setNome(dto.nome());
        clinica.setValorConsulta(dto.valorConsulta());
        clinica.setAtiva(true);

        Licenca licenca = new Licenca();
        licenca.setAtiva(true);
        licenca.setTipoLicenca(dto.licenca().tipoLicenca());
        licenca.setInicio(dto.licenca().inicio());
        licenca.setFim(dto.licenca().fim());
        licenca.setValor(dto.licenca().valor());
        licenca.setClinica(clinica);
        clinica.setLicenca(licenca);

        Funcionario funcionario = new Funcionario(dto.user());
        clinica.addFuncionario(funcionario);

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

        return clinica.getId();
    }

    public String createAdmin(CreateAdminDto dto) throws Exception {

        if (userRepository.findByEmailOrLogin(dto.login()).isPresent()) {
            throw new IllegalArgumentException("Usuário com email: " + dto.login() + " já existe");
        }

        AdminMaster admin = new AdminMaster(dto);

        userRepository.save(admin);

        return admin.getId();
    }

    public Clinica getClinicaById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClinicaById'");
    }

    public List<Clinica> getAllClinicas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClinicas'");
    }

}
