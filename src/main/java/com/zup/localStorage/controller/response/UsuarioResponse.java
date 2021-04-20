package com.zup.localStorage.controller.response;

import com.zup.localStorage.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioResponse {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private Long id;

    public UsuarioResponse(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.id = usuario.getId();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getId() {
        return id;
    }
}
