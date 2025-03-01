package com.example.tractor_muscle_api.repository;

import com.example.tractor_muscle_api.domain.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {


    @Query("""
            select e from Exercicio e
            where
             e.objetivo = :objetivo
            """)
    List<Exercicio> findByObjetivo( String objetivo);
}
