package com.helpdesk.backend.models;

import com.helpdesk.backend.enums.Perfil;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Tecnico extends Pessoa{
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
    }

    public Tecnico(Long id, String nome, String cpf, String email, String senha, Set<Perfil> perfis, LocalDate dataCriacao) {
        super(id, nome, cpf, email, senha, perfis, dataCriacao);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
