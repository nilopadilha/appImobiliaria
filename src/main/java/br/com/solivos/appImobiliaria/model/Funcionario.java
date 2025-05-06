package br.com.solivos.appImobiliaria.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 15, unique = true)
    private String matricula;

    private LocalDate admissao;

    // Relação Funcionario -> Pessoa (1 para 1, FK em Funcionario)
    // Um Funcionario está associado a uma Pessoa específica.
    // unique = true garante que uma Pessoa só pode ser referenciada por um Funcionario.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pessoa", referencedColumnName = "idPessoa", nullable = false, unique = true) // FK obrigatória e única
    private Pessoa pessoa;

    // Relação inversa: Funcionario -> Usuario (1 para 1)
    @OneToOne(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private Usuario usuario;

    // Relação inversa: Funcionario -> Negociacao (1 para Muitos)
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY)
    private List<Negociacao> negociacoes;
}
