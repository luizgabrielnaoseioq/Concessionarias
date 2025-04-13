package com.concessionaria.services;

import com.concessionaria.dtos.CidadeDTO;
import com.concessionaria.models.Cidade;
import com.concessionaria.repositories.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    // Create
    public CidadeDTO salvar(CidadeDTO dto) {
        Cidade cidade = dtoToEntity(dto);
        Cidade salva = cidadeRepository.save(cidade);
        return entityToDto(salva);
    }

    //Read
    public CidadeDTO buscarPorId(Long id) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
        return entityToDto(cidade);
    }

    public List<CidadeDTO> buscarTodos() {
        return cidadeRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public List<CidadeDTO> buscarPorNome(String nome) {
        return cidadeRepository.findByNome(nome)
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public List<CidadeDTO> buscarPorCep(String cep) {
        return cidadeRepository.findByCep(cep)
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    // Update
    public CidadeDTO atualizar(Long id, CidadeDTO dto) {
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        cidade.setNome(dto.getNome());
        cidade.setCep(dto.getCep());

        Cidade atualizada = cidadeRepository.save(cidade);
        return entityToDto(atualizada);
    }

    // Delete
    public void deletar(Long id) {
        if (!cidadeRepository.existsById(id)) {
            throw new RuntimeException("Cidade não encontrada");
        }
        cidadeRepository.deleteById(id);
    }

    // Conversores
    private Cidade dtoToEntity(CidadeDTO dto) {
        Cidade cidade = new Cidade();
        cidade.setId(dto.getId());
        cidade.setNome(dto.getNome());
        cidade.setCep(dto.getCep());
        return cidade;
    }

    private CidadeDTO entityToDto(Cidade cidade) {
        CidadeDTO dto = new CidadeDTO();
        dto.setId(cidade.getId());
        dto.setNome(cidade.getNome());
        dto.setCep(cidade.getCep());
        return dto;
    }
}