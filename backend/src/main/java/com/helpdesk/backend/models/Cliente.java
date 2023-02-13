package com.helpdesk.backend.models;

import com.helpdesk.backend.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente(Long id, String nome, String cpf, String email, String senha, Set<Perfil> perfis, LocalDate dataCriacao) {
        super(id, nome, cpf, email, senha, perfis, dataCriacao);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
