package com.br.ceac.service;

import com.br.ceac.model.Morador;
import com.br.ceac.repository.MoradorRepository;
import com.br.ceac.service.dto.MoradorDTO;
import com.br.ceac.service.mapper.MoradorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MoradorService {

    private final Logger log = LoggerFactory.getLogger(MoradorService.class);
    private MoradorRepository repository;
    private MoradorMapper mapper;

    public MoradorService(
            MoradorRepository repository,
            MoradorMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;

    }

    public MoradorDTO save(MoradorDTO dto) {
        log.debug("Request to post save Morador");
        Morador morador = mapper.toEntity(dto);
        morador = repository.save(morador);
        return mapper.toDto(morador);
    }

    @Transactional(readOnly = true)
    public Optional<MoradorDTO> findOne(Long id) {
        log.debug("Request to get one morador by id");
        return repository.findById(id).map(MoradorMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<MoradorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all morador");
        return repository.findAll(pageable).map(MoradorMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<MoradorDTO> findAllNotPage() {
        log.debug("Request to get all morador");
        return repository.findAll()
                .stream()
                .map(MoradorMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Page<MoradorDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search morador by keyword");
        return repository.searchByKeyword(param, pageable).map(MoradorMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete morador by id : {}", id);
        repository.deleteById(id);
    }

    public MoradorDTO update(MoradorDTO dto) {
        log.debug("Request to update morador: {}", dto);
        Morador morador = mapper.toEntity(dto);
        morador = repository.save(morador);
        return mapper.toDto(morador);
    }

}
