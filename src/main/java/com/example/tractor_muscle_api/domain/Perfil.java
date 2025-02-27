package com.example.tractor_muscle_api.domain;

import com.example.tractor_muscle_api.dto.PerfilDTO;
import com.example.tractor_muscle_api.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "perfil")
@Entity(name = "Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genero;
    private String idade;
    private double altura;
    private String biotipo;
    private String objetivo;
    private String disponibilidade;
    //private MedidasCorporais medidasCorporais;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public Perfil(PerfilDTO dados){
        this.genero = dados.genero();
        this.idade = dados.idade();
        this.altura = dados.altura();
        this.biotipo = dados.biotipo();
        this.objetivo = dados.objetivo();
        this.disponibilidade = dados.disponibilidade();
        //this.medidasCorporais = new MedidasCorporais(dados.medidasCorporais());
        this.usuario = dados.usuario();
    }
}
