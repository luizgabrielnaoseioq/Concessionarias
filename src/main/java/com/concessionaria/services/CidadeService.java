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

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    // Converter para o DTO
    // Converte Entidade para DTO
    public static CidadeDTO toDTO(Cidade cidade) {
        return new CidadeDTO(cidade.getId(), cidade.getNome(), cidade.getCep());
    }

    // Converte DTO para Entidade
    public static Cidade toEntity(CidadeDTO cidadeDTO) {
        return new Cidade(cidadeDTO.getId(), cidadeDTO.getNome(), cidadeDTO.getCep());
    }

    public List<CidadeDTO> findAll() {

        List<Cidade> cidades = cidadeRepository.findAll();

        return cidades.stream().map(CidadeService::toDTO).toList(); // Converte para DTO
    }

    // Buscar cidade por ID
    public CidadeDTO findById(@PathVariable Long id) {

        Cidade cidade = cidadeRepository.findById(id).get();
        return toDTO(cidade);
    }

    // Atualizar cidade por ID
    @Transactional
    public CidadeDTO update(CidadeDTO cidadeDTO) {

        Cidade cidade = cidadeRepository.findById(cidadeDTO.getId()).get();

        cidade.setNome(cidadeDTO.getNome());
        cidade.setCep(cidadeDTO.getCep());

        cidadeRepository.save(cidade);

        return findById(cidadeDTO.getId());
    }

    // Buscar cidades pelo nome
    public List<CidadeDTO> findByNome(String nome) {
        Optional<Cidade> cidades = cidadeRepository.findByNome(nome);
        return cidades.stream().map(CidadeService::toDTO).toList(); // Converte para DTO
    }

    // Criar ou atualizar uma cidade
    @Transactional
    public CidadeDTO save(CidadeDTO cidadeDTO) {

        Cidade cidade = cidadeRepository.save(toEntity(cidadeDTO));
        return toDTO(cidade);
    }

    // Deletar cidade pelo ID
    @Transactional
    public void deleteById(Long id) {
        cidadeRepository.deleteById(id);
    }
}
