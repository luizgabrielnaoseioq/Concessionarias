package com.concessionaria.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeDTO {

    private Long id;
    private String nome;
    private String cep;

    public CidadeDTO() {

    }

    public CidadeDTO(Long id, String nome, String cep) {
    }

}