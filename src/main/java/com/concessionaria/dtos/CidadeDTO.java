package com.concessionaria.dtos;

import lombok.Data;

@Data
public class CidadeDTO {

    private Long id;
    private String nome;
    private String cep;

    public CidadeDTO(Long id, String nome, String cep) {
    }
}