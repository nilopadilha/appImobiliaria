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
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 100)
    private String interesses;

    // Relação Cliente -> Pessoa (1 para 1, FK em Cliente)
    // Um Cliente está associado a uma Pessoa específica.
    // unique = true garante que uma Pessoa só pode ser referenciada por um Cliente.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pessoa", referencedColumnName = "idPessoa", nullable = false, unique = true) // FK obrigatória e única
    private Pessoa pessoa;

    // Relação inversa: Cliente -> Negociacao (1 para Muitos)
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Negociacao> negociacoes;
}
