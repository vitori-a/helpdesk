package com.helpdesk.backend.repositories;

import com.helpdesk.backend.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChamadoRepository extends JpaRepository <Chamado, Long> {

    boolean existsByNome(String nome);
    Optional<Chamado> findByNome(String nome);
}
