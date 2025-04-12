package com.concessionaria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcessionariaDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private Long enderecoId;
}
