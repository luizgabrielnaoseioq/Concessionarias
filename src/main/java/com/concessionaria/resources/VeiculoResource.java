package com.concessionaria.resources;

import com.concessionaria.dtos.VeiculoDTO;
import com.concessionaria.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/")
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok(veiculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO veiculoDTO) {
        return ResponseEntity.ok(veiculoService.save(veiculoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        return ResponseEntity.ok(veiculoService.update(id, veiculoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        veiculoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
