package com.br.ceac.controller;

import com.br.ceac.service.PortaoService;
import com.br.ceac.service.dto.PortaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/portao")
public class PortaoController {

    private PortaoService service;

    public PortaoController(PortaoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<PortaoDTO> save(@RequestBody PortaoDTO dto) throws URISyntaxException {
        PortaoDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/saveHs/" + result.getId())).body(dto);
    }

    @GetMapping("/findById/{id}")
    public Optional<PortaoDTO> findById(@PathVariable Long id) {
        Optional<PortaoDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<PortaoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<PortaoDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PortaoDTO> update(@RequestBody PortaoDTO dto) {
        PortaoDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
