package com.br.ceac.service;

import com.br.ceac.model.Mudanca;
import com.br.ceac.repository.MudancaRepository;
import com.br.ceac.service.dto.MudancaDTO;
import com.br.ceac.service.mapper.MudancaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MudancaService {

    private final Logger log = LoggerFactory.getLogger(MudancaService.class);
    private MudancaRepository repository;
    private MudancaMapper mapper;

    public MudancaService(MudancaRepository repository, MudancaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MudancaDTO save(MudancaDTO dto) {
        log.debug("Request to post save Mudanca");
        Mudanca mudanca = mapper.toEntity(dto);
        mudanca = repository.save(mudanca);
        return mapper.toDto(mudanca);
    }

    @Transactional(readOnly = true)
    public Optional<MudancaDTO> findOne(Long id) {
        log.debug("Request to get one Mudanca by id");
        return repository.findById(id).map(MudancaMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<MudancaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Mudanca");
        return repository.findAll(pageable).map(MudancaMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<MudancaDTO> findAllNotPage() {
        log.debug("Request to get all Mudanca");
        return repository.findAll()
                .stream()
                .map(MudancaMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Page<MudancaDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get searchByKeyword");
        return repository.searchByKeyword(param, pageable).map(MudancaMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Mudanca by id : {}", id);
        repository.deleteById(id);
    }

    public MudancaDTO update(MudancaDTO dto) {
        log.debug("Request to update Mudanca: {}", dto);
        Mudanca mudanca = mapper.toEntity(dto);
        mudanca = repository.save(mudanca);
        return mapper.toDto(mudanca);
    }

}
