package com.ew.elitewings.Security;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ew.elitewings.Security.dto.CreateSecurityDto;
import com.ew.elitewings.Security.dto.UpdateSecurityDto;
import com.ew.elitewings.Security.entity.SecurityEntity;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/security-reports")
@Tag(name = "SecurityReports", description = "Gestion de SecurityReports")
public class SecurityController {
    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    // Crear archivo de seguridad
    @Operation(summary = "Crear un SecurityReports")
    @PostMapping
    public ResponseEntity<SecurityEntity> createSecurity(@Validated @RequestBody CreateSecurityDto dto) {
        SecurityEntity createdCelebrity = securityService.createSecurity(dto);
        return ResponseEntity.status(201).body(createdCelebrity);
    }

    // Obtener un archivo de seguridad por ID
    @Operation(summary = "Detalles de SecurityReport con casos no resueltos")
    @GetMapping("/unresolved")
    public SecurityEntity getSecurityById(@PathVariable Long id) {
        return securityService.getSecurityById(id);
    }

    // Actualizar seguridad por ID (PATCH), marcar como caso resuelto
    @Operation(summary = "Actualizar SecurityReports como resuelto")
    @PatchMapping("/{id}/resolve")
    public ResponseEntity<SecurityEntity> updateSecurity(@PathVariable Long id,
            @Valid @RequestBody UpdateSecurityDto dto) {

        SecurityEntity updatedCelebrity = securityService.updateSecurity(id, dto);
        return ResponseEntity.ok(updatedCelebrity);
    }

}

