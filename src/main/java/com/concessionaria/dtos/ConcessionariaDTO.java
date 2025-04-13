package com.concessionaria.dtos;

import lombok.*;

@Getter
@Setter
public class ConcessionariaDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private Long enderecoId;

    public ConcessionariaDTO() {

    }

    public ConcessionariaDTO(Long id, String nome, String cnpj, Long enderecoId) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.enderecoId = enderecoId;
    }
}
