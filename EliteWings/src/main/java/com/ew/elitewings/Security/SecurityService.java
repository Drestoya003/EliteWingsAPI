package com.ew.elitewings.Security;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ew.elitewings.Security.dto.CreateSecurityDto;
import com.ew.elitewings.Security.dto.UpdateSecurityDto;
import com.ew.elitewings.Security.entity.SecurityEntity;
import com.ew.elitewings.Security.repository.SecurityRepository;


@Service
public class SecurityService {
    private final SecurityRepository securityRepository;
    private final ModelMapper modelMapper;

    public SecurityService(SecurityRepository securityRepository, ModelMapper modelMapper) {
        this.securityRepository = securityRepository;
        this.modelMapper = modelMapper;
    }

    // Crear un nuevo archivo de seguridad
    public SecurityEntity createSecurity(CreateSecurityDto dto) {
        SecurityEntity celebrityEntity = modelMapper.map(dto, SecurityEntity.class);
        return securityRepository.save(celebrityEntity);
    }
    // Eliminar por id
    public void deleteSecurity(long id){
        securityRepository.deleteById(id);
    }
    // Encontrar por id
    public SecurityEntity getSecurityById(long id) {
    return securityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Security with ID " + id + " not found"));
    }

    //Actualizar seguridad por id
    public SecurityEntity updateSecurity(Long id, UpdateSecurityDto dto) {
        SecurityEntity existingSecurity = securityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Security with ID " + id + " not found"));

        // Usar ModelMapper para mapear solo los valores no nulos
        modelMapper.map(dto, existingSecurity);

        return securityRepository.save(existingSecurity);
    }

}
