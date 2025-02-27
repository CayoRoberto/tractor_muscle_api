package com.example.tractor_muscle_api.controller;

import com.example.tractor_muscle_api.domain.Usuario;


import com.example.tractor_muscle_api.dto.AuthDTO;
import com.example.tractor_muscle_api.service.security.DateTokenJWT;
import com.example.tractor_muscle_api.service.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tractor_muscle/login")
//@CrossOrigin(origins = "http://localhost:4200")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthDTO dados){
        System.out.println("Login: " + dados.login());
        System.out.println("Senha: " + dados.senha());
        try{

            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            System.out.println("Chegou aqui");
            System.out.println("Chegou aqui: " + authenticationToken);

            var authentication = manager.authenticate(authenticationToken);
            System.out.println("Usuário autenticado com sucesso!");

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            System.out.println("Chegou aqui 3");

            return  ResponseEntity.ok(new DateTokenJWT(tokenJWT));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro na autenticação");
        }

    }
}
