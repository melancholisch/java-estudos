package com.zup.localStorage.controller.request;

import com.zup.localStorage.model.Usuario;
import com.zup.localStorage.validacoes.UniqueValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @UniqueValue(domainClass = Usuario.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(min = 11, max= 11)
    @UniqueValue(domainClass = Usuario.class, fieldName = "cpf")
    private String cpf;
    
    @NotNull
    private LocalDate dataNascimento;

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

    public Usuario converter() {
        return new Usuario(nome, email, cpf, dataNascimento);
    }
}
