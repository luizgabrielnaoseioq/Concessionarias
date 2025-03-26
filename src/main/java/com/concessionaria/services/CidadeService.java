package com.concessionaria.services;

import com.concessionaria.dtos.CidadeDTO;
import com.concessionaria.models.Cidade;
import com.concessionaria.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
        com.concessionaria.models.Cidade cidade = new com.concessionaria.models.Cidade(cidadeDTO);
        return new CidadeDTO(cidadeRepository.save(cidade));
    }

    public List<CidadeDTO> buscarTodos(){
        return cidadeRepository.findAll().stream().map(cidade -> new CidadeDTO(cidade)).toList();
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

    public CidadeDTO toEntity(Cidade cidade) {
        return new CidadeDTO(cidade);
    }
}
