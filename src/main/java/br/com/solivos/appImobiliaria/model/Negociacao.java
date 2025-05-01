package br.com.solivos.appImobiliaria.model;

import br.com.solivos.appImobiliaria.enumerat.StatusNegociacao;
import br.com.solivos.appImobiliaria.enumerat.TipoNegocio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_negociacao")
public class Negociacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data; // Data da negociação (ou início)

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @Column(precision = 15, scale = 2) // Valor a receber
    private BigDecimal vReceber;

    @Column(precision = 15, scale = 2) // Valor a pagar (em caso de troca com torna?)
    private BigDecimal vPagar;

    @Enumerated(EnumType.STRING)
    private TipoNegocio tipoNegocio;

    @Enumerated(EnumType.STRING)
    private StatusNegociacao status;

    private LocalDate dataVenc; // Vencimento de alguma parcela/acordo?

    // Relação Negociacao -> Cliente (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cliente", nullable = false) // Assumindo que toda negociação tem um cliente
    private Cliente cliente;

    // Relação Negociacao -> Funcionario (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Funcionario", nullable = false) // Assumindo que toda negociação tem um funcionário responsável
    private Funcionario funcionario;

    // Relação Negociacao -> Imovel (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Imovel", nullable = false) // Assumindo que toda negociação envolve um imóvel
    private Imovel imovel;

    // Relação inversa: Negociacao -> ContaAReceber (1 para Muitos)
    // A cardinalidade 1..* indica que deve haver pelo menos uma conta a receber.
    // Cuidado com CascadeType.ALL - remover negociação removeria as contas.
    @OneToMany(mappedBy = "negociacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContaReceber> contasAReceber;

    // Relação inversa: Negociacao -> ContaAPagar (1 para Muitos)
    // orphanRemoval=true garante que se uma ContaAPagar for removida da lista, ela é deletada do banco.
    @OneToMany(mappedBy = "negociacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContaPagar> contasAPagar;
}
