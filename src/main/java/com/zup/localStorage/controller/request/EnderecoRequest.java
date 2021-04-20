package com.zup.localStorage.controller.request;

import com.zup.localStorage.model.Endereco;
import com.zup.localStorage.model.Usuario;
import com.zup.localStorage.repository.UsuarioRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {

    //logradouro, número, complemento, bairro, cidade, estado e CEP

    @NotBlank
    private String logradouro;
    @NotNull
    private int numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String cep;

    @NotNull
    private Long idUsuario;

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Endereco converter(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findById(this.idUsuario).get();
        return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, usuario);
    }
}
