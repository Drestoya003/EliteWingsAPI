package com.ew.elitewings.Celebrity;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ew.elitewings.Celebrity.dto.CreateCelebrityDto;
import com.ew.elitewings.Celebrity.dto.UpdateCelebrityDto;
import com.ew.elitewings.Celebrity.entity.CelebrityEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/celebrities")  // Ruta base del controlador
@Tag(name = "Celebrities", description = "Gestión de celebridades")
public class CelebrityController {

    private final CelebrityService celebrityService;

    public CelebrityController(CelebrityService celebrityService) {
        this.celebrityService = celebrityService;
    }

    // Crear una nueva celebridad

    @Operation(summary = "Crear una nueva celebridad")
    @PostMapping
    public ResponseEntity<CelebrityEntity> createCelebrity(@Validated @RequestBody CreateCelebrityDto dto) {
        CelebrityEntity createdCelebrity = celebrityService.createCelebrity(dto);
        return ResponseEntity.status(201).body(createdCelebrity);
    }

    // Obtener una celebridad por ID
    @Operation(summary = "Obtener datos de una sola celebridad")
    @GetMapping("/{id}")
    public CelebrityEntity getCelebrityById(@PathVariable Long id) {
        return celebrityService.getCelebrityById(id);
    }

    // Actualizar una celebridad por ID (PATCH)
    @Operation(summary = "Actualizar datos de una clebridad")
    @PutMapping("/{id}")
    public ResponseEntity<CelebrityEntity> updateCelebrity(@PathVariable Long id,
            @Valid @RequestBody UpdateCelebrityDto dto) {

        CelebrityEntity updatedCelebrity = celebrityService.updateCelebrity(id, dto);
        return ResponseEntity.ok(updatedCelebrity);
    }

    // Eliminar una celebridad por ID
    @Operation(summary = "Eliminar una entidad")
    @DeleteMapping("/{id}")
    public void deleteCelebrity(@PathVariable Long id) {
        celebrityService.deleteCelebrity(id);
    }
}

