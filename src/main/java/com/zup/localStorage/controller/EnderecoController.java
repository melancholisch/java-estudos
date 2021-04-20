package com.zup.localStorage.controller;

import com.zup.localStorage.controller.request.EnderecoRequest;
import com.zup.localStorage.controller.response.EnderecoResponse;
import com.zup.localStorage.controller.response.UsuarioResponse;
import com.zup.localStorage.model.Endereco;
import com.zup.localStorage.model.Usuario;
import com.zup.localStorage.repository.EnderecoRepository;
import com.zup.localStorage.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<EnderecoResponse> cadastrar(@RequestBody @Valid EnderecoRequest request,
                                                      UriComponentsBuilder uriBuilder ){

        Endereco endereco = request.converter(usuarioRepository);
        enderecoRepository.save(endereco);

        URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoResponse(endereco));


    }
}
