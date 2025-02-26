package com.example.tractor_muscle_api.service;

import com.example.tractor_muscle_api.components.CodeSenhaBcrypt;
import com.example.tractor_muscle_api.domain.Usuario;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import com.example.tractor_muscle_api.repository.UsuarioRepository;
import com.example.tractor_muscle_api.service.validation.ValidadorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public Usuario cadastrar(UsuarioDTO dados) {

        if(usuarioRepository.existsByLogin(dados.login())){
            throw new ValidadorLogin("Email já cadastrado!");
        }
        Usuario novoUsuario = new Usuario(dados);

        CodeSenhaBcrypt cifra = new CodeSenhaBcrypt();
        String senhaCifrada = cifra.codificarSenha(dados.senha());

        novoUsuario.setSenha(senhaCifrada);
        //novoUsuario.setEsqueceuSenha(dados.esqueceuSenha());
        this.usuarioRepository.save(novoUsuario);

        return novoUsuario;

    }

    public Usuario pegarUsuario(String login) {
        Usuario usuario =  this.usuarioRepository.findUsuarioByLogin(login);
        //System.out.println("Usuario a senha foi esquecida? " + usuario.getEsqueceuSenha() );
        return usuario;
    }

    public Usuario pegarUsuarioPorEmail(String email) {
        return this.usuarioRepository.findUsuarioByEmail(email);
    }

}
