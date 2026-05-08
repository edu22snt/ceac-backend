package com.br.ceac.service;

import com.br.ceac.model.ControleAcesso;
import com.br.ceac.repository.ControleAcessoRepository;
import com.br.ceac.service.dto.ControleAcessoDTO;
import com.br.ceac.service.mapper.ControleAcessoMapper;
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
public class ControleAcessoService {

    private final Logger log = LoggerFactory.getLogger(MoradorService.class);
    private final ControleAcessoRepository repository;
    private ControleAcessoMapper mapper;

    public ControleAcessoService(ControleAcessoRepository repository, ControleAcessoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ControleAcessoDTO create(ControleAcessoDTO dto) {
        log.debug("Request to post create ControleAcesso");
        ControleAcesso entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public ControleAcessoDTO update(ControleAcessoDTO dto) {
        log.debug("Request to update ControleAcesso : {}", dto);
        if (dto.getId() == null) {
            throw new RuntimeException("ID não pode ser nulo para atualização");
        }

        ControleAcesso entity = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("ControleAcesso não encontrado"));


        return ControleAcessoMapper.toDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public Optional<ControleAcessoDTO> findById(Long id) {
        log.debug("Request to get one ControleAcesso by id");
        return repository.findById(id).map(ControleAcessoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<ControleAcessoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ControleAcesso");
        return repository.findAll(pageable)
                .map(ControleAcessoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<ControleAcessoDTO> findAllNotPage() {
        log.debug("Request to get all ControleAcesso");
        return repository.findAll()
                .stream()
                .map(ControleAcessoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Page<ControleAcessoDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get search ControleAcesso by keyword");
        return repository.searchByKeyword(param, pageable).map(ControleAcessoMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete ControleAcesso by id : {}", id);
        if (!repository.existsById(id)) {
            throw new RuntimeException("ControleAcesso não encontrado");
        }
        repository.deleteById(id);
    }

}
