package com.helpdesk.backend.services;

import com.helpdesk.backend.models.Cliente;
import com.helpdesk.backend.models.Usuario;
import com.helpdesk.backend.repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> listar(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public void deletar(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
