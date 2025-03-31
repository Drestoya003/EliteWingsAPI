package com.ew.elitewings.PrivateJet;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ew.elitewings.PrivateJet.dto.CreatePrivateJetDto;
import com.ew.elitewings.PrivateJet.dto.UpdatePrivateJetDto;
import com.ew.elitewings.PrivateJet.entity.PrivateJetEntity;
import com.ew.elitewings.PrivateJet.repository.PrivateJetRepository;


@Service
public class PrivateJetService {
    private final PrivateJetRepository privateJetRepository;
    private final ModelMapper modelMapper;

    public PrivateJetService(PrivateJetRepository privateJetRepository, ModelMapper modelMapper) {
        this.privateJetRepository = privateJetRepository;
        this.modelMapper = modelMapper;
    }

    // Crear un nuevo jet
    public PrivateJetEntity createPrivateJet(CreatePrivateJetDto dto) {
        PrivateJetEntity celebrityEntity = modelMapper.map(dto, PrivateJetEntity.class);
        return privateJetRepository.save(celebrityEntity);
    }
    // Encontrar jet por id
    public PrivateJetEntity getPrivateJetById(long id) {
    return privateJetRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Celebrity with ID " + id + " not found"));
    }

    //Actualizar jet por id
    public PrivateJetEntity updatePrivateJet(Long id, UpdatePrivateJetDto dto) {
        PrivateJetEntity existingCelebrity = privateJetRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Celebrity with ID " + id + " not found"));

        // Usar ModelMapper para mapear solo los valores no nulos
        modelMapper.map(dto, existingCelebrity);

        return privateJetRepository.save(existingCelebrity);
    }
    // Eliminar por id
    public void deletePrivateJet(long id){
        privateJetRepository.deleteById(id);
    }

}