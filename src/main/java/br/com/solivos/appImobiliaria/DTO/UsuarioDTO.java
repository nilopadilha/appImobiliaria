package br.com.solivos.appImobiliaria.DTO;

import br.com.solivos.appImobiliaria.model.Funcionario;
import br.com.solivos.appImobiliaria.model.Perfil;
import br.com.solivos.appImobiliaria.model.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private Funcionario funcionario;
    private Perfil perfil;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.perfil = usuario.getPerfil();
        this.funcionario = usuario.getFuncionario();

    }

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setLogin(this.login);
        usuario.setPerfil(this.perfil);
        return usuario;
    }
}
