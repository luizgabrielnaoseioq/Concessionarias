package com.concessionaria.resources;

import com.concessionaria.dtos.CidadeDTO;
import com.concessionaria.models.Cidade;
import com.concessionaria.services.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {



    private final CidadeService cidadeService;

    public CidadeResource(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarCidade(@PathVariable Long id) {
        Cidade cidade = cidadeService.buscarCidade(id);
        return ResponseEntity.ok(new CidadeDTO(cidade));
    }

    @GetMapping("/buscar")
    public ResponseEntity<CidadeDTO> buscarCidade(@RequestParam String cep) {
        Cidade cidade = cidadeService.buscarCidadePorCep(cep);
        return ResponseEntity.ok(new CidadeDTO(cidade));
    }

    @PostMapping("/")
    public ResponseEntity<CidadeDTO> criarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.salvarCidade(cidadeDTO));
    }

    @PutMapping()
    public ResponseEntity<CidadeDTO> atualizarCidade(@RequestBody CidadeDTO cidadeDTO) {
        return ResponseEntity.ok(cidadeService.atualizarCidade(cidadeDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarCidade(@RequestBody CidadeDTO cidadeDTO) {
        cidadeService.deletarCidade(cidadeDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
