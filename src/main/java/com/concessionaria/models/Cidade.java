package com.concessionaria.models;

import com.concessionaria.dtos.CidadeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "tb_cidade")

public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    private String nome;

    private String cep;

    @Column(name = "is_verificado")
    private Boolean isVerificado;

    public Cidade() {
    }

    public Cidade(String estado, String nome) {
        this.estado = estado;
        this.nome = nome;
        this.cep = cep;
        this.isVerificado = isVerificado;
    }

    //para salvar objeto lá do cidadeService
    public Cidade(CidadeDTO cidadeDTO) {
        this.estado = cidadeDTO.getEstado();
        this.nome = cidadeDTO.getNome();
        this.cep = cidadeDTO.getCep();
        this.isVerificado = cidadeDTO.getIsVerificado();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id == cidade.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}