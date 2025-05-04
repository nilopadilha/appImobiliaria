package br.com.solivos.appImobiliaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false, unique = true)
    private String login;

    @Column(length = 30, nullable = false) // Senhas devem ser armazenadas como hash, tamanho pode precisar ser maior
    private String senha;

    // Relação Usuario -> Funcionario (1 para 1, FK em Usuario)
    // Um Usuario está associado a um Funcionario específico.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Funcionario", referencedColumnName = "idFuncionario", nullable = false) // FK obrigatória
    private Funcionario funcionario;

    // Relação Usuario -> Perfil (Muitos para 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Perfil", nullable = false) // FK obrigatória
    private Perfil perfil;

    public Usuario(String nome, String login, Funcionario funcionario, Perfil perfil) {
    }
}
