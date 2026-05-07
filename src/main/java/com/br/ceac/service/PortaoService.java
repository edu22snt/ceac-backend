package com.br.ceac.service;

import com.br.ceac.model.Portao;
import com.br.ceac.repository.PortaoRepository;
import com.br.ceac.service.dto.PortaoDTO;
import com.br.ceac.service.mapper.PortaoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PortaoService {

    private final Logger log = LoggerFactory.getLogger(PortaoService.class);
    private PortaoRepository repository;
    private PortaoMapper mapper;

    public PortaoService(PortaoRepository repository, PortaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PortaoDTO save(PortaoDTO dto) {
        log.debug("Request to post save Portao");
        Portao portao = mapper.toEntity(dto);
        portao = repository.save(portao);
        return mapper.toDto(portao);
    }

    @Transactional(readOnly = true)
    public Optional<PortaoDTO> findOne(Long id) {
        log.debug("Request to get one Portao by id");
        return repository.findById(id).map(PortaoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<PortaoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Portao");
        return repository.findAll(pageable).map(PortaoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<PortaoDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get searchByKeyword");
        return repository.searchByKeyword(param, pageable).map(PortaoMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Portao by id : {}", id);
        repository.deleteById(id);
    }

    public PortaoDTO update(PortaoDTO dto) {
        log.debug("Request to update Portao: {}", dto);
        Portao portao = mapper.toEntity(dto);
        portao = repository.save(portao);
        return mapper.toDto(portao);
    }


}
