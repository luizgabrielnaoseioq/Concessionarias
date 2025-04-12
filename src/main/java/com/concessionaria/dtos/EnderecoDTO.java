package com.concessionaria.dtos;

import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private CidadeDTO cidade;

    public EnderecoDTO(Long id, String rua, String numero, String bairro, CidadeDTO cidade) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
}
