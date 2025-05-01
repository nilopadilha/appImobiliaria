package br.com.solivos.appImobiliaria.repository;

import br.com.solivos.appImobiliaria.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
