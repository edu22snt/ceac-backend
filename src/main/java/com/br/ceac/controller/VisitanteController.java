package com.br.ceac.controller;

import com.br.ceac.service.*;
import com.br.ceac.service.dto.VeiculoDTO;
import com.br.ceac.service.dto.VisitanteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visitante")
public class VisitanteController {

    private VisitanteService service;

    public VisitanteController(VisitanteService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<VisitanteDTO> save(@RequestBody VisitanteDTO dto) throws URISyntaxException {
        VisitanteDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/saveHs/" + result.getId())).body(dto);
    }

    @GetMapping("/findById/{id}")
    public Optional<VisitanteDTO> findById(@PathVariable Long id) {
        Optional<VisitanteDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<VisitanteDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<VisitanteDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<VisitanteDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<VisitanteDTO> update(@RequestBody VisitanteDTO dto) {
        VisitanteDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
