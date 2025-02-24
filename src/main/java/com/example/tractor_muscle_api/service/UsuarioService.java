package com.example.tractor_muscle_api.service;

import com.example.tractor_muscle_api.domain.Usuario;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import com.example.tractor_muscle_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario inserirDados(UsuarioDTO dados) {

        System.out.println("Usuario: " + dados.nome());
        Usuario user = new Usuario(dados);

        this.usuarioRepository.save(user);
        return user;

    }

    public Usuario pegarUsuario(String email) {
        Usuario usuario =  this.usuarioRepository.findUsuarioByEmail(email);
        //System.out.println("Usuario a senha foi esquecida? " + usuario.getEsqueceuSenha() );
        return usuario;
    }

    public Usuario pegarUsuarioPorEmail(String email) {
        return this.usuarioRepository.findUsuarioByEmail(email);
    }
}
