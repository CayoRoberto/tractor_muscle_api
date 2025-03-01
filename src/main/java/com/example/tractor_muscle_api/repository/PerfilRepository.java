package com.example.tractor_muscle_api.repository;

import com.example.tractor_muscle_api.domain.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    boolean existsByUsuarioId(Long idUsuario);

    @Query("""
            select p from Perfil p
            join p.usuario u
            where
            u.id = :idUsuario
            """)
    Perfil buscarPerfilbyUser(Long idUsuario);
}
