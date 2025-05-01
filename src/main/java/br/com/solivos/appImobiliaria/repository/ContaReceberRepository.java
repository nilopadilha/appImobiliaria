package br.com.solivos.appImobiliaria.repository;

import br.com.solivos.appImobiliaria.model.ContaReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaReceberRepository extends JpaRepository<ContaReceber, Long> {
}
