package com.concessionaria.services;

import com.concessionaria.dtos.FuncionarioDTO;
import com.concessionaria.models.Concessionaria;
import com.concessionaria.models.Funcionario;
import com.concessionaria.repositories.ConcessionariaRepository;
import com.concessionaria.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public FuncionarioDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
        return toDTO(funcionario);
    }

    @Transactional
    public FuncionarioDTO save(FuncionarioDTO dto) {
        Funcionario funcionario = toEntity(dto);
        funcionario = funcionarioRepository.save(funcionario);
        return toDTO(funcionario);
    }

    @Transactional
    public FuncionarioDTO update(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));

        funcionario.setNome(dto.getNome());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSalario(dto.getSalario());

        if (dto.getConcessionariaId() != null) {
            Concessionaria concessionaria = concessionariaRepository.findById(dto.getConcessionariaId())
                    .orElseThrow(() -> new RuntimeException("Concessionária não encontrada com ID: " + dto.getConcessionariaId()));
            funcionario.setConcessionaria(concessionaria);
        }

        funcionario = funcionarioRepository.save(funcionario);
        return toDTO(funcionario);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado com ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    private FuncionarioDTO toDTO(Funcionario funcionario) {
        Long concessionariaId = funcionario.getConcessionaria() != null ? funcionario.getConcessionaria().getId() : null;
        return new FuncionarioDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                concessionariaId
        );
    }

    private Funcionario toEntity(FuncionarioDTO dto) {
        Concessionaria concessionaria = null;
        if (dto.getConcessionariaId() != null) {
            concessionaria = concessionariaRepository.findById(dto.getConcessionariaId())
                    .orElseThrow(() -> new RuntimeException("Concessionária não encontrada com ID: " + dto.getConcessionariaId()));
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSalario(dto.getSalario());
        funcionario.setConcessionaria(concessionaria);
        return funcionario;
    }
}
