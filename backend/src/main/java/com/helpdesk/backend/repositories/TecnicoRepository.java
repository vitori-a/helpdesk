package com.helpdesk.backend.repositories;

import com.helpdesk.backend.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    boolean existsByNome(String nome);
    Optional<Tecnico> findByNome(String nome);

}
