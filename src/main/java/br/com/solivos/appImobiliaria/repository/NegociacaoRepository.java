package br.com.solivos.appImobiliaria.repository;

import br.com.solivos.appImobiliaria.model.Negociacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long> {
}
