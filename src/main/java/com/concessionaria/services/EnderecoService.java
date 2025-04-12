package com.concessionaria.services;

import com.concessionaria.dtos.EnderecoDTO;
import com.concessionaria.models.Endereco;
import com.concessionaria.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll().stream().map(EnderecoService::toDTO).toList();
    }

    public EnderecoDTO findById(Long id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        return toDTO(endereco);
    }

    @Transactional
    public EnderecoDTO update(Long id, EnderecoDTO dto) {
        Endereco endereco = enderecoRepository.findById(id).get();

        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());

        return toDTO(enderecoRepository.save(endereco));
    }

    @Transactional
    public EnderecoDTO save(EnderecoDTO dto) {
        return toDTO(enderecoRepository.save(toEntity(dto)));
    }

    @Transactional
    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }

    public static EnderecoDTO toDTO(Endereco e) {
        return new EnderecoDTO(e.getId(), e.getRua(), e.getNumero(), e.getBairro(), e.getCidade());
    }

    public static Endereco toEntity(EnderecoDTO dto) {
        return new Endereco(dto.getId(), dto.getRua(), dto.getNumero(), dto.getBairro(), dto.getCidade());
    }
}
