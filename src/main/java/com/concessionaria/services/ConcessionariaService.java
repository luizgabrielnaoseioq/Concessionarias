package com.concessionaria.services;

import com.concessionaria.dtos.ConcessionariaDTO;
import com.concessionaria.models.Concessionaria;
import com.concessionaria.models.Endereco;
import com.concessionaria.repositories.ConcessionariaRepository;
import com.concessionaria.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcessionariaService {

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<ConcessionariaDTO> findAll() {
        return concessionariaRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ConcessionariaDTO findById(Long id) {
        Concessionaria concessionaria = concessionariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Concessionária não encontrada com ID: " + id));
        return toDTO(concessionaria);
    }

    @Transactional
    public ConcessionariaDTO save(ConcessionariaDTO dto) {
        Concessionaria concessionaria = toEntity(dto);
        concessionaria = concessionariaRepository.save(concessionaria);
        return toDTO(concessionaria);
    }

    @Transactional
    public ConcessionariaDTO update(Long id, ConcessionariaDTO dto) {
        Concessionaria concessionaria = concessionariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Concessionária não encontrada com ID: " + id));

        concessionaria.setNome(dto.getNome());
        concessionaria.setCnpj(dto.getCnpj());

        if (dto.getEnderecoId() != null) {
            Endereco endereco = enderecoRepository.findById(dto.getEnderecoId())
                    .orElseThrow(() -> new RuntimeException("Endereço não encontrado com ID: " + dto.getEnderecoId()));
            concessionaria.setEndereco(endereco);
        }

        concessionaria = concessionariaRepository.save(concessionaria);
        return toDTO(concessionaria);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!concessionariaRepository.existsById(id)) {
            throw new RuntimeException("Concessionária não encontrada com ID: " + id);
        }
        concessionariaRepository.deleteById(id);
    }

    private ConcessionariaDTO toDTO(Concessionaria concessionaria) {
        Long enderecoId = concessionaria.getEndereco() != null ? concessionaria.getEndereco().getId() : null;
        return new ConcessionariaDTO(
                concessionaria.getId(),
                concessionaria.getNome(),
                concessionaria.getCnpj(),
                enderecoId
        );
    }

    private Concessionaria toEntity(ConcessionariaDTO dto) {
        Endereco endereco = null;
        if (dto.getEnderecoId() != null) {
            endereco = enderecoRepository.findById(dto.getEnderecoId())
                    .orElseThrow(() -> new RuntimeException("Endereço não encontrado com ID: " + dto.getEnderecoId()));
        }

        Concessionaria concessionaria = new Concessionaria();
        concessionaria.setId(dto.getId());
        concessionaria.setNome(dto.getNome());
        concessionaria.setCnpj(dto.getCnpj());
        concessionaria.setEndereco(endereco);
        return concessionaria;
    }
}
