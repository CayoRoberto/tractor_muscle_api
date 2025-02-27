package com.example.tractor_muscle_api.domain;

import com.example.tractor_muscle_api.dto.MedidasCorporaisDTO;
import com.example.tractor_muscle_api.dto.PerfilDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medidas_corporais")
@Entity(name = "MedidasCorporais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedidasCorporais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double peitoral;
    private double barriga;
    private double quadril;
    @Column(name = "biceps_direito")
    private double bicepsDireito;
    @Column(name = "biceps_esquerdo")
    private double bicepsEsquerdo;
    @Column(name = "antibraco_direito")
    private double antibracoDireito;
    @Column(name = "antibraco_esquerdo")
    private double antibracoEsquerdo;
    @Column(name = "coxa_direita")
    private double coxaDireita;
    @Column(name = "coxa_esquerda")
    private double coxaEsquerda;
    @Column(name = "panturrilha_direita")
    private double panturrilhaDireita;
    @Column(name = "panturrilha_esquerda")
    private double panturrilhaEsquerda;
    @Column(name = "gordura_corporal")
    private String gorduraCorporal;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public MedidasCorporais(MedidasCorporais dados){
        this.peitoral = dados.peitoral;
        this.barriga = dados.barriga;
        this.quadril = dados.quadril;
        this.bicepsDireito = dados.bicepsDireito;
        this.bicepsEsquerdo = dados.bicepsEsquerdo;
        this.antibracoDireito = dados.antibracoDireito;
        this.antibracoEsquerdo = dados.antibracoEsquerdo;
        this.coxaDireita = dados.coxaDireita;
        this.coxaEsquerda = dados.coxaEsquerda;
        this.panturrilhaDireita = dados.panturrilhaDireita;
        this.panturrilhaEsquerda = dados.panturrilhaEsquerda;
        this.gorduraCorporal = dados.gorduraCorporal;
        this.usuario = dados.usuario;
    }

}
