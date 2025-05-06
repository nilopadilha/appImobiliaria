package br.com.solivos.appImobiliaria.model;

import br.com.solivos.appImobiliaria.enumerate.StatusImovel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_imovel")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(precision = 2, scale = 0) // Numeric(2)
    private Integer quartos;

    @Column(precision = 2, scale = 0) // Numeric(2)
    private Integer vgaragem; // vagas garagem

    private Boolean ativo = true;

    @Column(precision = 25, scale = 10) // Ajuste precisão/escala conforme necessidade
    private BigDecimal latitude;

    @Column(precision = 25, scale = 10) // Ajuste precisão/escala conforme necessidade
    private BigDecimal longitude;

    private Boolean venda = false;
    private Boolean locacao = false;
    private Boolean troca = false;

    @Column(precision = 15, scale = 2) // Numeric(15) - Valor monetário
    private BigDecimal vVenda; // valor venda

    @Column(precision = 15, scale = 2) // Numeric(15) - Valor monetário
    private BigDecimal vLocacao; // valor locação

    @Enumerated(EnumType.STRING)
    private StatusImovel status;

    @Column(precision = 10, scale = 2) // Numeric(10)
    private BigDecimal mTerreno; // metros terreno

    @Column(precision = 10, scale = 2) // Numeric(10)
    private BigDecimal mImovel; // metros imóvel (área construída)

    @Column(length = 100)
    private String rua;

    @Column(length = 8)
    private String cep;

    @Lob // Para campos maiores como imagens (byte array) ou texto longo
    @Column(length = 1024) // O length aqui pode ser mais indicativo para DDL
    private byte[] imagem; // Ou String se for apenas o path/URL da imagem

    @Column(precision = 10, scale = 2) // Numeric(10)
    private BigDecimal vIptu; // valor IPTU

    @Column(precision = 10, scale = 2) // Numeric(10)
    private BigDecimal vCondominio; // valor condomínio

    @Column(precision = 10, scale = 2) // Numeric(10)
    private BigDecimal vTaxas; // outras taxas

    // Relação Imovel -> Bairro (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Bairro") // FK opcional pela cardinalidade 0..* no Imovel
    private Bairro bairro;

    // Relação inversa: Imovel -> Negociacao (1 para Muitos)
    @OneToMany(mappedBy = "imovel", fetch = FetchType.LAZY)
    private List<Negociacao> negociacoes;
}
