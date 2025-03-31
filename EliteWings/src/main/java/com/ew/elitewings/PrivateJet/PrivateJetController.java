package com.ew.elitewings.PrivateJet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ew.elitewings.PrivateJet.dto.CreatePrivateJetDto;
import com.ew.elitewings.PrivateJet.dto.UpdatePrivateJetDto;
import com.ew.elitewings.PrivateJet.entity.PrivateJetEntity;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/jets")
@Tag(name = "Private Jets", description = "Gestión de Private Jets")
public class PrivateJetController {
    private final PrivateJetService privateJetService;

    public PrivateJetController(PrivateJetService privateJetService) {
        this.privateJetService = privateJetService;
    }

    // Crear un nuevo jet
    @Operation(summary = "Registrar un nuevo PrivateJet")
    @PostMapping
    public ResponseEntity<PrivateJetEntity> createPrivateJet(@Validated @RequestBody CreatePrivateJetDto dto) {
        PrivateJetEntity createdCelebrity = privateJetService.createPrivateJet(dto);
        return ResponseEntity.status(201).body(createdCelebrity);
    }

    // Obtener detalles del jet
    @Operation(summary = "Obtener detalles de un PricvateJet con su ID")
    @GetMapping("/{id}")
    public PrivateJetEntity getPrivateJetById(@PathVariable Long id) {
        return privateJetService.getPrivateJetById(id);
    }

    // Actualizar info jet por id
    @Operation(summary = "Actualizar info de un PrivateJet con su ID")
    @PatchMapping("/{id}")
    public ResponseEntity<PrivateJetEntity> updatePrivateJet(@PathVariable Long id,
            @Valid @RequestBody UpdatePrivateJetDto dto) {

        PrivateJetEntity updatedCelebrity = privateJetService.updatePrivateJet(id, dto);
        return ResponseEntity.ok(updatedCelebrity);
    }

    // Eliminar un jet por id
    @Operation(summary = "Eliminar un PrivateJet")
    @DeleteMapping("/{id}")
    public void deletePrivateJet(@PathVariable Long id) {
        privateJetService.deletePrivateJet(id);
    }
}
