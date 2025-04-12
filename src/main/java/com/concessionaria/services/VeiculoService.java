package com.concessionaria.services;

import com.concessionaria.dtos.VeiculoDTO;
import com.concessionaria.models.Veiculo;
import com.concessionaria.repositories.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll() {
        return veiculoRepository.findAll().stream().map(VeiculoService::toDTO).toList();
    }

    public VeiculoDTO findById(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).get();
        return toDTO(veiculo);
    }

    @Transactional
    public VeiculoDTO update(Long id, VeiculoDTO dto) {
        Veiculo veiculo = veiculoRepository.findById(id).get();

        veiculo.setModelo(dto.getModelo());
        veiculo.setMarca(dto.getMarca());
        veiculo.setAno(dto.getAno());
        veiculo.setPreco(dto.getPreco());

        return toDTO(veiculoRepository.save(veiculo));
    }

    @Transactional
    public VeiculoDTO save(VeiculoDTO dto) {
        return toDTO(veiculoRepository.save(toEntity(dto)));
    }

    @Transactional
    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }

    public static VeiculoDTO toDTO(Veiculo v) {
        return new VeiculoDTO(v.getId(), v.getModelo(), v.getMarca(), v.getAno(), v.getPreco());
    }

    public static Veiculo toEntity(VeiculoDTO dto) {
        return new Veiculo(dto.getId(), dto.getModelo(), dto.getMarca(), dto.getAno(), dto.getPreco());
    }
}
