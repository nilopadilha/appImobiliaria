package br.com.solivos.appImobiliaria.model;

import br.com.solivos.appImobiliaria.enumerate.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 50)
    private String apelido;

    @Column(length = 14, unique = true) // CPF ou CNPJ podem precisar de validação/máscara
    private String cpf_cnpj;

    @Column(length = 20)
    private String telefone;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String rua;

    @Column(precision = 10, scale = 0) // Numeric(10)
    private Integer numero; // Usando Integer para número de endereço

    @Column(length = 8)
    private String cep;

    private Boolean ativo = true; // Valor padrão

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo; // Assumindo um Enum TipoPessoa

    // Relação Pessoa -> Bairro (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Bairro") // FK opcional pela cardinalidade 0..*
    private Bairro bairro;

    // Relationships where Pessoa is referenced
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private Set<Cliente> clientes;
}
