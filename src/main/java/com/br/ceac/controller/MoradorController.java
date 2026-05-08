package com.br.ceac.controller;

import com.br.ceac.service.MoradorService;
import com.br.ceac.service.dto.MoradorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/morador")
public class MoradorController {

    private MoradorService service;

    MoradorController(MoradorService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<MoradorDTO> save(@RequestBody MoradorDTO dto) throws URISyntaxException {
        MoradorDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/repasse/{id}")
    public Optional<MoradorDTO> findById(@PathVariable Long id) {
        Optional<MoradorDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<MoradorDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<MoradorDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<MoradorDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<MoradorDTO> update(@RequestBody MoradorDTO dto) {
        MoradorDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }

}
