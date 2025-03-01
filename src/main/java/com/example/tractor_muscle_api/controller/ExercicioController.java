package com.example.tractor_muscle_api.controller;

import com.example.tractor_muscle_api.domain.Exercicio;
import com.example.tractor_muscle_api.service.ExercicioService;
import com.example.tractor_muscle_api.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tractor_muscle/exercicio")
public class ExercicioController {

    @Autowired
    ExercicioService exercicioService;

    @GetMapping(path = "/personalizado/{idUsuario}")
    public ResponseEntity<List<Exercicio>> buscarTreinosPersonalizados(@PathVariable Long idUsuario) {

        List<Exercicio> treinos = exercicioService.buscarExerciciosPorUsuario(idUsuario);
        if (treinos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(treinos);
    }
}
