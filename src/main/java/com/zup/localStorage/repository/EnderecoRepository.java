package com.zup.localStorage.repository;

import com.zup.localStorage.model.Endereco;
import com.zup.localStorage.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.EndElement;
import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByUsuario (Usuario usuario);
}
