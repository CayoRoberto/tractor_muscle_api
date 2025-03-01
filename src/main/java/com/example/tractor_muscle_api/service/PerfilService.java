package com.example.tractor_muscle_api.service;

import com.example.tractor_muscle_api.components.CodeSenhaBcrypt;
import com.example.tractor_muscle_api.domain.Exercicio;
import com.example.tractor_muscle_api.domain.Perfil;
import com.example.tractor_muscle_api.domain.Usuario;
import com.example.tractor_muscle_api.dto.PerfilDTO;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import com.example.tractor_muscle_api.repository.ExercicioRepository;
import com.example.tractor_muscle_api.repository.PerfilRepository;
import com.example.tractor_muscle_api.repository.UsuarioRepository;
import com.example.tractor_muscle_api.service.validation.ValidadorLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;


    public Perfil cadastrar(PerfilDTO dados) {


        Perfil perfil = new Perfil(dados);

        this.perfilRepository.save(perfil);

        // Cria treinos personalizados baseados no objetivo
        List<Exercicio> treinos = criarTreinosBaseadosNoPerfil(perfil);
        exercicioRepository.saveAll(treinos);

        return perfil;

    }

    public boolean perfilExisteParaUsuario(Long idUsuario) {
        return perfilRepository.existsByUsuarioId(idUsuario);
    }

    private List<Exercicio> criarTreinosBaseadosNoPerfil(Perfil perfil) {
        List<Exercicio> treinos = new ArrayList<>();

        //String objetivo = perfil.getObjetivo().toLowerCase();

        if (perfil.getObjetivo().equalsIgnoreCase("Construir músculos")) {
            treinos.add(new Exercicio(null, "Supino Reto", "Peito - Força e volume", 4, 10, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Crucifixo", "Peito - Isolado", 3, 12, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Agachamento Livre", "Pernas - Foco em força", 4, 10, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Leg Press", "Pernas - Complementar", 4, 12, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Puxada Frontal", "Costas - Desenvolvimento de dorsais", 4, 10, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Remada Curvada", "Costas - Espessura", 4, 10, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Rosca Direta", "Bíceps - Força e volume", 4, 12, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Tríceps Pulley", "Tríceps - Definição e força", 4, 12, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Desenvolvimento Militar", "Ombros - Força", 4, 10, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Elevação Lateral", "Ombros - Isolado", 3, 12, perfil.getObjetivo()));

        } else if (perfil.getObjetivo().equalsIgnoreCase("Perda de pesa e perda de gordura")) {
            treinos.add(new Exercicio(null, "Corrida HIIT", "Cardio - Intervalado", 5, 3, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Burpees", "Treino funcional", 4, 15, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Agachamento Livre", "Pernas - Com foco em gasto calórico", 4, 12, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Polichinelos", "Aeróbico - Corpo todo", 4, 20, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Mountain Climbers", "Funcional - Abdômen e cardio", 4, 20, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Prancha", "Core - Resistência", 3, 30, perfil.getObjetivo()));
            treinos.add(new Exercicio(null, "Avanço com halteres", "Pernas e glúteos", 4, 12, perfil.getObjetivo()));

        }
//        else if (objetivo.contains("condicionamento") || objetivo.contains("bem-estar")) {
//            treinos.add(new Exercicio(null, "Caminhada Rápida", "Cardio leve", 5, 5));
//            treinos.add(new Exercicio(null, "Alongamento Global", "Flexibilidade", 3, 30));
//            treinos.add(new Exercicio(null, "Circuito Funcional", "Força e resistência geral", 4, 15));
//            treinos.add(new Exercicio(null, "Agachamento Livre", "Pernas", 4, 12));
//            treinos.add(new Exercicio(null, "Flexão de Braço", "Peito e braços", 4, 12));
//            treinos.add(new Exercicio(null, "Remada TRX", "Costas e braços", 3, 12);
//            treinos.add(new Exercicio(null, "Abdominal Supra", "Core", 4, 15));
//        } else {
//            // Caso objetivo não seja reconhecido, um plano básico genérico
//            treinos.add(new Exercicio(null, "Caminhada", "Leve e moderada", 3, 5));
//            treinos.add(new Exercicio(null, "Alongamento Básico", "Mobilidade", 3, 30));
//            treinos.add(new Exercicio(null, "Agachamento Livre", "Básico de força", 3, 12));
//            treinos.add(new Exercicio(null, "Flexão de Braço", "Peito e tríceps", 3, 10));
//            treinos.add(new Exercicio(null, "Abdominal Supra", "Básico de abdômen", 3, 15));
//        }

        return treinos;
    }

    public Perfil buscarPerfilPorUsuario(Long idUsuario) {
        return perfilRepository.buscarPerfilbyUser(idUsuario);
    }
}
