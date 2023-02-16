package com.helpdesk.backend.services;

import com.helpdesk.backend.dtos.ClienteDto;
import com.helpdesk.backend.models.Cliente;
import com.helpdesk.backend.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDto salvar(ClienteDto clienteDto){
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        clienteRepository.save(cliente);

        return modelMapper.map(cliente, ClienteDto.class);
    }

    public Page<ClienteDto> obter(Pageable pageable){
        return clienteRepository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, ClienteDto.class));
    }

    public ClienteDto buscarPorId(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public ClienteDto atualizar(Long id, ClienteDto clienteDto){
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);

        cliente.setId(id);
        cliente = clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteDto.class);
    }
    public void deletar(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
