package br.com.solivos.appImobiliaria.repository;

import br.com.solivos.appImobiliaria.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
