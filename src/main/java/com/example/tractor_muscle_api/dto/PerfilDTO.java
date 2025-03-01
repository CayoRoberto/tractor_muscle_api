package com.example.tractor_muscle_api.dto;

import com.example.tractor_muscle_api.domain.MedidasCorporais;
import com.example.tractor_muscle_api.domain.Usuario;

public record PerfilDTO(
        String genero,
        double idade,
        double altura,
        String biotipo,
        String objetivo,
        String disponibilidade,
        //MedidasCorporais medidasCorporais,
        Usuario usuario) {
}
