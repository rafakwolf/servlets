package br.com.rafakwolf.gerenciador.dao;

import br.com.rafakwolf.gerenciador.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDao {
    private final static Map<String, Usuario> USUARIOS = new HashMap<>();
    static {
        USUARIOS.put("guilherme.silveira@alura.com.br", new Usuario("guilherme.silveira@alura.com.br","silveira"));
        USUARIOS.put("rodrigo.turini@alura.com.br", new Usuario("rodrigo.turini@alura.com.br","turini"));
    }

    public Usuario buscaPorEmailESenha(String email, String senha) {
        if (!USUARIOS.containsKey(email))
            return null;

        Usuario usuario = USUARIOS.get(email);
        if (usuario.getSenha().equals(senha))
            return usuario;

        return null;
    }
}
