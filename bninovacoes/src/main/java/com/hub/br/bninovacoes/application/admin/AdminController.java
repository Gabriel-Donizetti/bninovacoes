package com.hub.br.bninovacoes.application.admin;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.hub.br.bninovacoes.application.admin.representation.AdminDto.CreateAdminDto;
import com.hub.br.bninovacoes.application.admin.representation.ClinicaDto.CreateClinicaDto;
import com.hub.br.bninovacoes.application.utils.ErrorDto;
import com.hub.br.bninovacoes.application.utils.ResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/clinica")
    public ResponseEntity<?> createClinica(@RequestBody @Valid CreateClinicaDto dto) {
        try {

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(service.createClinica(dto))
                    .toUri();

            return ResponseEntity.created(uri).body(new ResponseDto("Clínica criada"));

        } catch (Exception e) {
            return ResponseEntity.status(409).body(new ErrorDto(e.getMessage()));
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<?> createAdmin(@RequestBody @Valid CreateAdminDto dto) {
        try {

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(service.createAdmin(dto))
                    .toUri();

            return ResponseEntity.created(uri).body(new ResponseDto("Admin criado"));

        } catch (Exception e) {

            return ResponseEntity.status(409).body(new ErrorDto(e.getMessage()));
        }
    }

    @GetMapping("/clinicas")
    public ResponseEntity<?> getAllClinicas() {

        try {
            return ResponseEntity.ok().body(new ResponseDto(service.getAllClinicas()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping("/clinicas/{id}")
    public ResponseEntity<?> getClinicaById(@PathVariable Integer id) {

        try {
            return ResponseEntity.ok().body(new ResponseDto(service.getClinicaById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAdmins() {
        return ResponseEntity.ok("Listagem de admins");
    }

    @PutMapping("/clinica")
    public ResponseEntity<?> updateClinica() {
        return ResponseEntity.ok("Clínica atualizada");
    }

    @PutMapping("/admin")
    public ResponseEntity<?> updateAdmin() {
        return ResponseEntity.ok("Admin atualizado");
    }

    @DeleteMapping("/clinica")
    public ResponseEntity<?> deleteClinica() {
        return ResponseEntity.ok("Clínica deletada");
    }

    @DeleteMapping("/admin")
    public ResponseEntity<?> deleteAdmin() {
        return ResponseEntity.ok("Admin deletado");
    }
}
