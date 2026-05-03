package com.br.ceac.controller;

import com.br.ceac.service.CondominioService;
import com.br.ceac.service.dto.CondominioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/condominio")
public class CondominioController {

    private final CondominioService service;

    public CondominioController(CondominioService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<CondominioDTO> create(@RequestBody CondominioDTO dto) throws URISyntaxException {
        CondominioDTO result = service.create(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<CondominioDTO> update(@RequestBody CondominioDTO dto) {
        CondominioDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CondominioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<CondominioDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<CondominioDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}