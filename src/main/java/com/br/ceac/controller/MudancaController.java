package com.br.ceac.controller;

import com.br.ceac.service.MudancaService;
import com.br.ceac.service.VisitanteService;
import com.br.ceac.service.dto.MudancaDTO;
import com.br.ceac.service.dto.VisitanteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mudanca")
public class MudancaController {

    private MudancaService service;

    public MudancaController(MudancaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<MudancaDTO> save(@RequestBody MudancaDTO dto) throws URISyntaxException {
        MudancaDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/saveHs/" + result.getId())).body(dto);
    }

    @GetMapping("/findById/{id}")
    public Optional<MudancaDTO> findById(@PathVariable Long id) {
        Optional<MudancaDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<MudancaDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<MudancaDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<MudancaDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<MudancaDTO> update(@RequestBody MudancaDTO dto) {
        MudancaDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
