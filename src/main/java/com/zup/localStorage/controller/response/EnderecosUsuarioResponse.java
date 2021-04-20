package com.zup.localStorage.controller.response;

import com.zup.localStorage.model.Endereco;
import com.zup.localStorage.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EnderecosUsuarioResponse {


    private String usuario;
    private List<EnderecoResponse> enderecos;

    @Deprecated
    public EnderecosUsuarioResponse(){

    }

    public EnderecosUsuarioResponse(Usuario usuario, List<EnderecoResponse> enderecos) {
        this.usuario = usuario.getEmail();
        this.enderecos = enderecos;

    }

    public String getUsuario() {
        return usuario;
    }

    public List<EnderecoResponse> getEnderecos() {
        return enderecos;
    }
}
