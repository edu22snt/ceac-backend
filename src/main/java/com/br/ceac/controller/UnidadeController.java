package com.br.ceac.controller;

import com.br.ceac.service.UnidadeService;
import com.br.ceac.service.dto.UnidadeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {

    private final UnidadeService service;

    public UnidadeController(UnidadeService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<UnidadeDTO> create(@RequestBody UnidadeDTO dto) throws URISyntaxException {
        UnidadeDTO result = service.create(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<UnidadeDTO> update(@RequestBody UnidadeDTO dto) {
        UnidadeDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UnidadeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<UnidadeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<UnidadeDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<UnidadeDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
