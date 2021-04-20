package com.zup.localStorage.controller;

import com.zup.localStorage.controller.request.UsuarioRequest;
import com.zup.localStorage.controller.response.EnderecoResponse;
import com.zup.localStorage.controller.response.EnderecosUsuarioResponse;
import com.zup.localStorage.controller.response.UsuarioResponse;
import com.zup.localStorage.model.Usuario;
import com.zup.localStorage.repository.EnderecoRepository;
import com.zup.localStorage.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequest request, UriComponentsBuilder uriBuilder){

        Usuario usuario = request.converter();
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));

    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable("id") Long id){

        Optional<Usuario> buscarUsuario = usuarioRepository.findById(id);
        if(buscarUsuario.isPresent()){
            List<EnderecoResponse> enderecos = enderecoRepository.findByUsuario(buscarUsuario.get()).stream()
                                                .map(endereco -> new EnderecoResponse(endereco)).collect(Collectors.toList());
            return ResponseEntity.ok()
                    .body(new EnderecosUsuarioResponse(buscarUsuario.get(), enderecos));
        }

        return ResponseEntity.notFound().build();
    }
}
