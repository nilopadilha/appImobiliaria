package br.com.solivos.appImobiliaria.model;

import br.com.solivos.appImobiliaria.enumerate.StatusConta;
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
@Table(name = "tb_contapagar")
public class ContaPagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusConta status;

    private LocalDate dataVenc; // data vencimento
    private LocalDate dataQuitacao; // data quitação

    @Column(precision = 15, scale = 2, nullable = false) // Valor monetário
    private BigDecimal valorPag; // valor a pagar

    // Relação ContaAPagar -> Negociacao (Muitos para 1)
    // A cardinalidade 0..* no lado ContaAPagar significa que a FK pode ser nula,
    // mas o diagrama mostra FK obrigatória. Ajustando para nullable = false.
    // Se uma conta a pagar PODE existir sem negociação, seria nullable = true.
    // Baseado no FK, parece ser obrigatório.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Negociacao", nullable = false) // Assumindo que está sempre ligada a uma negociação
    private Negociacao negociacao;
}
