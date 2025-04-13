package com.concessionaria.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDTO {

    private Long id;
    private String modelo;
    private String marca;
    private int ano;
    private double preco;

    public VeiculoDTO() {

    }

    public VeiculoDTO(Long id, String modelo, String marca, int ano, double preco) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
    }
}
