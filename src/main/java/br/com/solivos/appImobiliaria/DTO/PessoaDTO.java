package br.com.solivos.appImobiliaria.DTO;

import br.com.solivos.appImobiliaria.enumerate.TipoPessoa;
import br.com.solivos.appImobiliaria.model.Bairro;
import br.com.solivos.appImobiliaria.model.Pessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class PessoaDTO implements Serializable {
    private Long id;
    private String nome;
    private String apelido;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String rua;
    private Integer numero;
    private String cep;
    private Boolean ativo;
    private TipoPessoa tipo;
    private Bairro bairro; // Foreign key as ID


    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.apelido = pessoa.getApelido();
        this.cpfCnpj = pessoa.getCpf_cnpj();
        this.telefone = pessoa.getTelefone();
        this.email = pessoa.getEmail();
        this.rua = pessoa.getRua();
        this.numero = pessoa.getNumero();
        this.cep = pessoa.getCep();
        this.ativo = pessoa.getAtivo();
        this.tipo = pessoa.getTipo();
        this.bairro = pessoa.getBairro();

    }

    public Pessoa toPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.id);
        pessoa.setNome(this.nome);
        pessoa.setApelido(this.apelido);
        pessoa.setCpf_cnpj(this.cpfCnpj);
        pessoa.setTelefone(this.telefone);
        pessoa.setEmail(this.email);
        pessoa.setRua(this.rua);
        pessoa.setNumero(this.numero);
        pessoa.setCep(this.cep);
        pessoa.setAtivo(this.ativo);
        pessoa.setTipo(this.tipo);
        pessoa.setBairro(this.bairro);

        return  pessoa;
    }
}
