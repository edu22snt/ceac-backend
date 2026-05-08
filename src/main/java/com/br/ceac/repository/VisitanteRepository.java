package com.br.ceac.repository;

import com.br.ceac.model.Visitante;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

    @Query("SELECT t FROM Visitante t WHERE " +
            "LOWER(t.nome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.telefone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.unidade.bloco) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.unidade.apartamento) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.veiculo.placa) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.veiculo.marca) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.veiculo.modelo) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.tipoDocumento) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.documento) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Visitante> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
