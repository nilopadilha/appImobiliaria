package br.com.solivos.appImobiliaria.repository;

import br.com.solivos.appImobiliaria.model.ContaPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {
}
