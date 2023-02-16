package com.helpdesk.backend.services;

import com.helpdesk.backend.dtos.ChamadoDto;
import com.helpdesk.backend.models.Chamado;
import com.helpdesk.backend.repositories.ChamadoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

    @Autowired
    private ModelMapper modelMapper;
    private ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public ChamadoDto salvar(ChamadoDto chamadoDto){
        Chamado chamado = modelMapper.map(chamadoDto, Chamado.class);
        chamadoRepository.save(chamado);

        return modelMapper.map(chamado, ChamadoDto.class);
    }

    public Page<ChamadoDto> obter(Pageable pageable){
        return chamadoRepository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, ChamadoDto.class));
    }

    public ChamadoDto buscarPorId(Long id){
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(chamado, ChamadoDto.class);
    }

    public ChamadoDto atualizar(Long id, ChamadoDto chamadoDto){
        Chamado chamado = modelMapper.map(chamadoDto, Chamado.class);

        chamado.setId(id);
        chamado = chamadoRepository.save(chamado);
        return modelMapper.map(chamado, ChamadoDto.class);
    }
    public void deletar(Chamado chamado){
        chamadoRepository.delete(chamado);
    }
}
