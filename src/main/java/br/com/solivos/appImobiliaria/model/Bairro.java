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
@Table(name = "tb_bairro")
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    // Relação Bairro -> Cidade (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cidade", nullable = false) // FK obrigatória (cardinalidade 1 no lado Cidade)
    private Cidade cidade;

    // Relação inversa: Bairro -> Pessoa (1 para Muitos)
    @OneToMany(mappedBy = "bairro", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas;

    // Relação inversa: Bairro -> Imovel (1 para Muitos)
    @OneToMany(mappedBy = "bairro", fetch = FetchType.LAZY)
    private List<Imovel> imoveis;
}
