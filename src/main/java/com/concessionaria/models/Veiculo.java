package com.concessionaria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String marca;
    private String placa;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private String cor;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "concessionaria_id")
    private Concessionaria concessionaria;
}
