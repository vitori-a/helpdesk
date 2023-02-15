package com.helpdesk.backend.services;

import com.helpdesk.backend.models.Cliente;
import com.helpdesk.backend.models.Tecnico;
import com.helpdesk.backend.repositories.TecnicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    private TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public Tecnico salvar(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);
    }

    public Page<Tecnico> listar(Pageable pageable){
        return tecnicoRepository.findAll(pageable);
    }

    public Optional<Tecnico> buscarPorId(Long id){
        return tecnicoRepository.findById(id);
    }

    public void deletar(Tecnico tecnico){
        tecnicoRepository.delete(tecnico);
    }
}