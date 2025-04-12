package com.concessionaria.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String cargo;
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "concessionaria_id")
    private Concessionaria concessionaria;
}
