package com.concessionaria.services;

import com.concessionaria.dtos.CidadeDTO;
import com.concessionaria.models.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    private com.concessionaria.repositories.CidadeRepository cidadeRepository;

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
        com.concessionaria.models.Cidade cidade = new com.concessionaria.models.Cidade(cidadeDTO);
        return new CidadeDTO(cidadeRepository.save(cidade));
    }

    public Cidade buscarCidade(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada"));
    }

    public Cidade buscarCidadePorCep(String cep) {
        return cidadeRepository.findByCep(cep).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada"));
    }

    public CidadeDTO atualizarCidade(CidadeDTO cidadeDTO) {
        if (cidadeDTO.getId() == null) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Cidade cidade = cidadeRepository.findById(cidadeDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada"));
        cidade = new Cidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return new CidadeDTO(cidade);
    }
    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }
}
