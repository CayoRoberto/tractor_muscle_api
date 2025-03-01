package com.example.tractor_muscle_api.service;

import com.example.tractor_muscle_api.domain.Exercicio;
import com.example.tractor_muscle_api.domain.Perfil;
import com.example.tractor_muscle_api.repository.ExercicioRepository;
import com.example.tractor_muscle_api.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Exercicio> buscarExerciciosPorUsuario(Long idUsuario) {
        Perfil perfil = perfilRepository.buscarPerfilbyUser(idUsuario);


        if (perfil == null) {
            throw new IllegalArgumentException("Perfil não encontrado para o usuário com ID: " + idUsuario);
        }
        return exercicioRepository.findByObjetivo(perfil.getObjetivo());

    }
}
