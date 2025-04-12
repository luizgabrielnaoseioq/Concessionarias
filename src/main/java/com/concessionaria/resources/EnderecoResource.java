package com.concessionaria.resources;

import com.concessionaria.dtos.EnderecoDTO;
import com.concessionaria.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/")
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok(enderecoService.save(enderecoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok(enderecoService.update(id, enderecoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enderecoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
