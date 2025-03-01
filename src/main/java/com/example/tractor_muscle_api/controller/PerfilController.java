package com.example.tractor_muscle_api.controller;

import com.example.tractor_muscle_api.domain.Perfil;
import com.example.tractor_muscle_api.domain.Usuario;
import com.example.tractor_muscle_api.dto.PerfilDTO;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import com.example.tractor_muscle_api.service.PerfilService;
import com.example.tractor_muscle_api.service.UsuarioService;
import com.example.tractor_muscle_api.service.validation.ValidadorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tractor_muscle/perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<?> cadastrarDados(@RequestBody PerfilDTO dados){
       System.out.println("Perfil: " + dados.genero());
        System.out.println("Perfil do usuário: " + dados.usuario().getNome());
        Perfil p = new Perfil(dados);
        try {
            Perfil perfil = perfilService.cadastrar(dados);
            return ResponseEntity.status(HttpStatus.CREATED).body("Perfil do usuário cadastrado com sucesso!");
        }catch (ValidadorLogin exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar perfil do usuário");
        }

    }

    @GetMapping("/existe/{idUsuario}")
    public ResponseEntity<Boolean> verificarSePerfilExiste(@PathVariable Long idUsuario) {
        System.out.println("Perfil: " + idUsuario);
        boolean existe = perfilService.perfilExisteParaUsuario(idUsuario);
        System.out.println("Existe: " + existe);
        return ResponseEntity.ok(existe);
    }


    @GetMapping("/buscar-por-usuario/{idUsuario}")
    public ResponseEntity<Perfil> buscarPerfilPorUsuario(@PathVariable Long idUsuario) {
        Perfil perfil = perfilService.buscarPerfilPorUsuario(idUsuario);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(perfil);
    }
}
