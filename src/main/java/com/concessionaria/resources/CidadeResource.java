package com.concessionaria.resources;

import com.concessionaria.dtos.CidadeDTO;

import com.concessionaria.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public ResponseEntity<List<CidadeDTO>> findAll(CidadeDTO cidade) {
        return ResponseEntity.ok(cidadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.findById(id));
    }


    @PostMapping("/")
    public ResponseEntity<CidadeDTO> save(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.save(cidadeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<CidadeDTO>> update(@PathVariable Long id, @RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok((List<CidadeDTO>) cidadeService.update(cidadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cidadeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
