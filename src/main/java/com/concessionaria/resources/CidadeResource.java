package com.concessionaria.resources;

import com.concessionaria.dtos.CidadeDTO;
import com.concessionaria.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<CidadeDTO> criar(@RequestBody CidadeDTO dto) {
        CidadeDTO nova = cidadeService.salvar(dto);
        return new ResponseEntity<>(nova, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> buscarTodos(@RequestParam(required = false) String nome) {
        if (nome != null) {
            return ResponseEntity.ok(cidadeService.buscarPorNome(nome));
        }
        return ResponseEntity.ok(cidadeService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeDTO> atualizar(@PathVariable Long id, @RequestBody CidadeDTO dto) {
        return ResponseEntity.ok(cidadeService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}