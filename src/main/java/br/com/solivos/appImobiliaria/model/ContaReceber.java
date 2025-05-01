package br.com.solivos.appImobiliaria.model;

import br.com.solivos.appImobiliaria.enumerat.StatusConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_conatareceber")
public class ContaReceber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusConta status;

    @Column(precision = 15, scale = 2, nullable = false) // Valor monetário
    private BigDecimal valorRec; // valor a receber

    private LocalDate dataVenc; // data vencimento
    private LocalDate dataQuitacao; // data quitação

    // Relação ContaAReceber -> Negociacao (Muitos para 1)
    // nullable = false reflete a cardinalidade 1..* no lado da ContaAReceber
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Negociacao", nullable = false)
    private Negociacao negociacao;
}
