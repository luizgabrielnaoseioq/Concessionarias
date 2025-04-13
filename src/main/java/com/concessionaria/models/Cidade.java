package com.concessionaria.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "tb_cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cep;

    public Cidade() {
    }

    public Cidade(Long id, String nome, String cep) {
    }

}