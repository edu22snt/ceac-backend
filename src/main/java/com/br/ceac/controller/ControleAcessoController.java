package com.br.ceac.controller;

import com.br.ceac.service.ControleAcessoService;
import com.br.ceac.service.dto.ControleAcessoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controleAcesso")
public class ControleAcessoController {

    private ControleAcessoService service;

    ControleAcessoController(ControleAcessoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<ControleAcessoDTO> create(@RequestBody ControleAcessoDTO dto) throws URISyntaxException {
        ControleAcessoDTO result = service.create(dto);
        return ResponseEntity.created(new URI("/api/save/" + result.getId())).body(dto);
    }

    @GetMapping("/findById/{id}")
    public Optional<ControleAcessoDTO> findById(@PathVariable Long id) {
        Optional<ControleAcessoDTO> ControleAcesso = service.findById(id);
        return ControleAcesso;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<ControleAcessoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<ControleAcessoDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<ControleAcessoDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ControleAcessoDTO> update(@RequestBody ControleAcessoDTO dto) {
        ControleAcessoDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
