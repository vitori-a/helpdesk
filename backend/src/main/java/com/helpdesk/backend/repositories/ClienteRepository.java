package com.helpdesk.backend.repositories;

import com.helpdesk.backend.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByNome(String nome);
    Optional<Cliente> findByNome(String nome);
}
