package com.example.tractor_muscle_api.components;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CodificadorDeSenhaBcrypt {

    public String codificarSenha(String senha){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // Gerar um sal aleatório
//        String salGerado = BCrypt.gensalt();
//        System.out.println("O sal gerado foi $" + salGerado + "$");
//
//        // Gerar a senha hasheada utilizando o sal gerado
//        String senhaHasheada = BCrypt.hashpw(senha, salGerado);
//        System.out.println("O sal gerado foi $" + senhaHasheada + "$");

        String senhaHasheada = encoder.encode(senha);
        System.out.println("O sal gerado foi $" + senhaHasheada + "$");
        return senhaHasheada;
    }

    public boolean validarSenhaCifrada(String senhaCifrada, String senha){
        return BCrypt.checkpw(senhaCifrada, senha);
    }
}
