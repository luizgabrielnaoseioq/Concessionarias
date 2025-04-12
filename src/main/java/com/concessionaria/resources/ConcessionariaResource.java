package com.concessionaria.resources;

import com.concessionaria.dtos.ConcessionariaDTO;
import com.concessionaria.services.ConcessionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concessionaria")
public class ConcessionariaResource {

    @Autowired
    private ConcessionariaService concessionariaService;

    @GetMapping("/")
    public ResponseEntity<List<ConcessionariaDTO>> findAll() {
        return ResponseEntity.ok(concessionariaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcessionariaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(concessionariaService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<ConcessionariaDTO> save(@RequestBody ConcessionariaDTO concessionariaDTO) {
        return ResponseEntity.ok(concessionariaService.save(concessionariaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcessionariaDTO> update(@PathVariable Long id, @RequestBody ConcessionariaDTO concessionariaDTO) {
        return ResponseEntity.ok(concessionariaService.update(id, concessionariaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        concessionariaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
