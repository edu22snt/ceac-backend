package com.br.ceac.service;

import com.br.ceac.model.Condominio;
import com.br.ceac.repository.CondominioRepository;
import com.br.ceac.service.dto.CondominioDTO;
import com.br.ceac.service.mapper.CondominioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CondominioService {

    private final Logger log = LoggerFactory.getLogger(MoradorService.class);
    private final CondominioRepository repository;
    private CondominioMapper mapper;

    public CondominioService(CondominioRepository repository, CondominioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CondominioDTO create(CondominioDTO dto) {
        log.debug("Request to post create Contrato");
        Condominio entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public CondominioDTO update(CondominioDTO dto) {
        log.debug("Request to update Condominio : {}", dto);
        if (dto.getId() == null) {
            throw new RuntimeException("ID não pode ser nulo para atualização");
        }

        Condominio entity = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Condominio não encontrado"));

        entity.setNome(dto.getNome());
        entity.setEndereco(dto.getEndereco());

        return CondominioMapper.toDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public CondominioDTO findById(Long id) {
        log.debug("Request to get Condominio by id : {}", id);
        return repository.findById(id)
                .map(CondominioMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Condominio não encontrado"));
    }

    @Transactional(readOnly = true)
    public Page<CondominioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Condominio");
        return repository.findAll(pageable)
                .map(CondominioMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<CondominioDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search Condominio by keyword");
        return repository.searchByKeyword(param, pageable).map(CondominioMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Condominio by id : {}", id);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Condominio não encontrado");
        }
        repository.deleteById(id);
    }
}
