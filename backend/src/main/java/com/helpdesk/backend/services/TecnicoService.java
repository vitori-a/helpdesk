package com.helpdesk.backend.services;

import com.helpdesk.backend.dtos.TecnicoDto;
import com.helpdesk.backend.models.Tecnico;
import com.helpdesk.backend.repositories.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private ModelMapper modelMapper;

    private TecnicoRepository tecnicoRepository;

    public TecnicoDto salvar(TecnicoDto tecnicoDto){
        Tecnico tecnico = modelMapper.map(tecnicoDto, Tecnico.class);
        tecnicoRepository.save(tecnico);

        return modelMapper.map(tecnico, TecnicoDto.class);
    }

    public Page<TecnicoDto> obter(Pageable pageable){
        return tecnicoRepository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, TecnicoDto.class));
    }

    public TecnicoDto buscarPorId(Long id){
        Tecnico tecnico = tecnicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(tecnico, TecnicoDto.class);
    }

    public TecnicoDto atualizar(Long id, TecnicoDto tecnicoDto){
        Tecnico tecnico = modelMapper.map(tecnicoDto, Tecnico.class);

        tecnico.setId(id);
        tecnico = tecnicoRepository.save(tecnico);
        return modelMapper.map(tecnico, TecnicoDto.class);
    }
    public void deletar(Tecnico tecnico){
        tecnicoRepository.delete(tecnico);
    }
}
