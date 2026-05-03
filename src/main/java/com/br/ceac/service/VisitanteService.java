package com.br.ceac.service;

import com.br.ceac.model.Visitante;
import com.br.ceac.repository.VisitanteRepository;
import com.br.ceac.service.dto.VisitanteDTO;
import com.br.ceac.service.mapper.VisitanteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VisitanteService {

    private final Logger log = LoggerFactory.getLogger(VisitanteService.class);
    private VisitanteRepository repository;
    private VisitanteMapper mapper;

    public VisitanteService(VisitanteRepository repository, VisitanteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public VisitanteDTO save(VisitanteDTO dto) {
        log.debug("Request to post save Visitante");
        Visitante visitante = mapper.toEntity(dto);
        visitante = repository.save(visitante);
        return mapper.toDto(visitante);
    }

    @Transactional(readOnly = true)
    public Optional<VisitanteDTO> findOne(Long id) {
        log.debug("Request to get one Visitante by id");
        return repository.findById(id).map(VisitanteMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<VisitanteDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Visitante");
        return repository.findAll(pageable).map(VisitanteMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<VisitanteDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get searchByKeyword");
        return repository.searchByKeyword(param, pageable).map(VisitanteMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Visitante by id : {}", id);
        repository.deleteById(id);
    }

    public VisitanteDTO update(VisitanteDTO dto) {
        log.debug("Request to update Visitante: {}", dto);
        Visitante visitante = mapper.toEntity(dto);
        visitante = repository.save(visitante);
        return mapper.toDto(visitante);
    }


}
