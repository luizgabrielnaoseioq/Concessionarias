package com.concessionaria.dtos;

import com.concessionaria.models.Cidade;
import lombok.Data;

@Data
public class CidadeDTO {

    private String estado;
    private String nome;
    private String cep;
    private Boolean isVerificado;

    public CidadeDTO() {}

    public CidadeDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.estado = cidade.getEstado();
        this.nome = cidade.getNome();
        this.cep = cidade.getCep();
        this.isVerificado = cidade.getIsVerificado();
    }

}
