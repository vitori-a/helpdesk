package com.helpdesk.backend.services;

import com.helpdesk.backend.config.ModelMapper;
import com.helpdesk.backend.models.Chamado;
import com.helpdesk.backend.repositories.ChamadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {
    private ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public Chamado salvar(Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    public Page<Chamado> listar(Pageable pageable){
        return chamadoRepository.findAll(pageable);
    }

    public Optional<Chamado> buscarPorId(Long id){
        return chamadoRepository.findById(id);
    }

    public void deletar(Chamado chamado){
        chamadoRepository.delete(chamado);
    }
}
