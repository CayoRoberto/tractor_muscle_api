package com.example.tractor_muscle_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "exercicio")
@Entity(name = "Exercicio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Integer series;
    private Integer repeticoes;
    private String objetivo;


    public Exercicio() {
    }

    public Exercicio(Long id, String nome, String descricao, int series, int repeticoes, String objetivo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.series = series;
        this.repeticoes = repeticoes;
        this.objetivo = objetivo;
    }
}
