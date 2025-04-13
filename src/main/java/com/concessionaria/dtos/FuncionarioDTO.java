package com.concessionaria.dtos;

import lombok.*;

@Getter
@Setter
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private String cargo;
    private double salario;
    private Long concessionariaId;

    public FuncionarioDTO() {

    }

    public FuncionarioDTO(Long id, String nome, String cargo, double salario, Long concessionariaId) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.concessionariaId = concessionariaId;
    }
}
