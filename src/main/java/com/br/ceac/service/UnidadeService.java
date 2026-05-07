package com.br.ceac.service;

import com.br.ceac.model.Unidade;
import com.br.ceac.repository.UnidadeRepository;
import com.br.ceac.service.dto.UnidadeDTO;
import com.br.ceac.service.mapper.UnidadeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UnidadeService {

    private final Logger log = LoggerFactory.getLogger(UnidadeService.class);
    private final UnidadeRepository repository;
    private UnidadeMapper mapper;

    public UnidadeService(UnidadeRepository repository, UnidadeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UnidadeDTO create(UnidadeDTO dto) {
        log.debug("Request to post create Unidade");
        Unidade entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public UnidadeDTO update(UnidadeDTO dto) {
        log.debug("Request to update Unidade : {}", dto);
        if (dto.getId() == null) {
            throw new RuntimeException("ID não pode ser nulo para atualização");
        }

        Unidade entity = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Unidade não encontrada"));

        entity.setId(dto.getId());
        entity.setApartamento(dto.getApartamento());
        entity.setBloco(dto.getBloco());
        return UnidadeMapper.toDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public UnidadeDTO findById(Long id) {
        log.debug("Request to get Unidade by id : {}", id);
        return repository.findById(id)
                .map(UnidadeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Unidade não encontrado"));
    }

    @Transactional(readOnly = true)
    public Page<UnidadeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Unidade");
        return repository.findAll(pageable)
                .map(UnidadeMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<UnidadeDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Unidade by keyword");
        return repository.searchByKeyword(param, pageable).map(UnidadeMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Unidade by id : {}", id);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Unidade não encontrada");
        }
        repository.deleteById(id);
    }

}
