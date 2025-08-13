package com.hub.br.bninovacoes.application.funcionario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hub.br.bninovacoes.application.admin.representation.ClinicaDto.FuncionarioDto;
import com.hub.br.bninovacoes.application.utils.ResponseDto;

import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/criarfuncionario")
    public ResponseEntity<?> criarfuncionario(@RequestBody @Valid FuncionarioDto dto) {
        try{
            
             URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(funcionarioService.criarfuncionario(dto))
                    .toUri();
            
            return ResponseEntity.created(uri).body(new ResponseDto("Usuario criado"));
        }catch(Exception e){
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
    
}
