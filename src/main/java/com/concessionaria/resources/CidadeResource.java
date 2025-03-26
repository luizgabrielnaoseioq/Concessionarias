package com.concessionaria.resources;

import com.concessionaria.dtos.CidadeDTO;
import com.concessionaria.models.Cidade;
import com.concessionaria.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cidade")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Servico> buscarTodos(){
        return servicoService.buscarTodos();
    }

    @PostMapping("/")
    public ResponseEntity<CidadeDTO> criarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.salvarCidade(cidadeDTO));
    }

    @PutMapping("/")
    public ResponseEntity<CidadeDTO> atualizarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.atualizarCidade(cidadeDTO));
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deletarCidade(@RequestBody CidadeDTO cidadeDTO) {
        cidadeService.deletarCidade(cidadeDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
