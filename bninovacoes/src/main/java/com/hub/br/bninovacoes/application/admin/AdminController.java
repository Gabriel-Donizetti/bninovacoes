package com.hub.br.bninovacoes.application.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hub.br.bninovacoes.application.admin.representation.CreateClinicaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/clinica")
    public ResponseEntity<?> createClinica(@RequestBody @Valid CreateClinicaDto dto) {
        try {
            service.create(dto);

            return ResponseEntity.ok("Clínica criada");

        } catch (Exception e) {
            return ResponseEntity.status(401).body("");
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<?> createAdmin() {
        return ResponseEntity.ok("Admin criado");
    }

    @GetMapping("/clinicas")
    public ResponseEntity<?> getClinicas() {
        return ResponseEntity.ok("Listagem de clínicas");
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
