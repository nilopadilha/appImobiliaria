package br.com.solivos.appImobiliaria.repository;

import br.com.solivos.appImobiliaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     List<Usuario> findAll(String login);
}
