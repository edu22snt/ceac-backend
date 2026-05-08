package com.br.ceac.controller;

import com.br.ceac.service.VeiculoService;
import com.br.ceac.service.dto.VeiculoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

    private VeiculoService service;

    VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO dto) throws URISyntaxException {
        VeiculoDTO result = service.save(dto);
        return ResponseEntity.created(new URI("/api/saveHs/" + result.getId())).body(dto);
    }

    @GetMapping("/findById/{id}")
    public Optional<VeiculoDTO> findById(@PathVariable Long id) {
        Optional<VeiculoDTO> dto = service.findOne(id);
        return dto;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<VeiculoDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAllNotPage")
    public ResponseEntity<List<VeiculoDTO>> findAllNotPage() {
        return ResponseEntity.ok(service.findAllNotPage());
    }

    @GetMapping("/searchByKeyword")
    public ResponseEntity<Page<VeiculoDTO>> searchByKeyword(@RequestParam String param, Pageable pageable) {
        return ResponseEntity.ok(service.searchByKeyword(param, pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<VeiculoDTO> update(@RequestBody VeiculoDTO dto) {
        VeiculoDTO result = service.update(dto);
        return ResponseEntity.ok().body(result);
    }
}
