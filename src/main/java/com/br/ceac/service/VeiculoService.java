package com.br.ceac.service;

import com.br.ceac.model.Veiculo;
import com.br.ceac.repository.VeiculoRepository;
import com.br.ceac.service.dto.VeiculoDTO;
import com.br.ceac.service.mapper.VeiculoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class VeiculoService {

    private final Logger log = LoggerFactory.getLogger(VeiculoService.class);
    private VeiculoRepository repository;
    private VeiculoMapper mapper;

    public VeiculoService(VeiculoRepository repository, VeiculoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        log.debug("Request to post save Veiculo");
        Veiculo veiculo = mapper.toEntity(veiculoDTO);
        veiculo = repository.save(veiculo);
        return mapper.toDto(veiculo);
    }

    @Transactional(readOnly = true)
    public Optional<VeiculoDTO> findOne(Long id) {
        log.debug("Request to get one Veiculo by id");
        return repository.findById(id).map(VeiculoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<VeiculoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Veiculo");
        return repository.findAll(pageable).map(VeiculoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<VeiculoDTO> searchByKeyword(String param, Pageable pageable) {
        log.debug("Request to get searchByKeyword");
        return repository.searchByKeyword(param, pageable).map(VeiculoMapper::toDto);
    }

    public void delete(Long id) {
        log.debug("Request to delete Veiculo by id : {}", id);
        repository.deleteById(id);
    }

    public VeiculoDTO update(VeiculoDTO dto) {
        log.debug("Request to update Veiculo: {}", dto);
        Veiculo veiculo = mapper.toEntity(dto);
        veiculo = repository.save(veiculo);
        return mapper.toDto(veiculo);
    }


}
