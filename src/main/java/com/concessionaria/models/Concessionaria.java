package com.concessionaria.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "tb_concessionaria")
@Data
public class Concessionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "concessionaria")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "concessionaria")
    private List<Veiculo> veiculos;
}
