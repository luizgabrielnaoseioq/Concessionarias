package com.concessionaria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String bairro;
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
