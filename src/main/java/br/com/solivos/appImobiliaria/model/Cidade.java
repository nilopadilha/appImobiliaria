package br.com.solivos.appImobiliaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 2, nullable = false)
    private String uf;

    // Relação inversa: Cidade -> Bairro (1 para Muitos)
    // A cardinalidade 1..* no lado Bairro indica que uma cidade DEVE ter bairros.
    // JPA não força isso no mapeamento, mas a lógica de negócio sim.
    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY /*, cascade = CascadeType.ALL, orphanRemoval = true */ ) // Cuidado com cascade
    private List<Bairro> bairros; // Usar Set<Bairro> se a ordem não importar e unicidade for garantida
}
