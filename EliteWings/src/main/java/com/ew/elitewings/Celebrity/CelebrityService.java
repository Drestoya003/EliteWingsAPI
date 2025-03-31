package com.ew.elitewings.Celebrity;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ew.elitewings.Celebrity.dto.CreateCelebrityDto;
import com.ew.elitewings.Celebrity.dto.UpdateCelebrityDto;
import com.ew.elitewings.Celebrity.entity.CelebrityEntity;
import com.ew.elitewings.Celebrity.repository.CelebrityRepository;


@Service
public class CelebrityService {
    private final CelebrityRepository celebrityRepository;
    private final ModelMapper modelMapper;

    public CelebrityService(CelebrityRepository celebrityRepository, ModelMapper modelMapper) {
        this.celebrityRepository = celebrityRepository;
        this.modelMapper = modelMapper;
    }

    // Crear una nueva celebridad
    public CelebrityEntity createCelebrity(CreateCelebrityDto dto) {
        CelebrityEntity celebrityEntity = modelMapper.map(dto, CelebrityEntity.class);
        return celebrityRepository.save(celebrityEntity);
    }
    // Eliminar por id
    public void deleteCelebrity(long id){
        celebrityRepository.deleteById(id);
    }
    // Encontrar por id
    public CelebrityEntity getCelebrityById(long id) {
    return celebrityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Celebrity with ID " + id + " not found"));
    }

    //Actualizar celebridad por id
    public CelebrityEntity updateCelebrity(Long id, UpdateCelebrityDto dto) {
        CelebrityEntity existingCelebrity = celebrityRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Celebrity with ID " + id + " not found"));

        // Usar ModelMapper para mapear solo los valores no nulos
        modelMapper.map(dto, existingCelebrity);

        return celebrityRepository.save(existingCelebrity);
    }

}
