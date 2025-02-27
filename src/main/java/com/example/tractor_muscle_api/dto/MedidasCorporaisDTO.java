package com.example.tractor_muscle_api.dto;

import com.example.tractor_muscle_api.domain.Usuario;

public record MedidasCorporaisDTO(
        double peitoral,
        double barriga,
        double quadril,
        double bicepsDireito,
        double bicepsEsquerdo,
        double antibracoDireito,
        double antibracoEsquerdo,
        double coxaDireita,
        double coxaEsquerda,
        double panturrilhaDireita,
        double panturrilhaEsquerda,
        String gorduraCorporal,
        Usuario usuario
) {
}
