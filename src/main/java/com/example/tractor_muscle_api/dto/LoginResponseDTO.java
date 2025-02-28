package com.example.tractor_muscle_api.dto;

import com.example.tractor_muscle_api.domain.Usuario;

public record LoginResponseDTO(String token, Usuario usuario) {
}
