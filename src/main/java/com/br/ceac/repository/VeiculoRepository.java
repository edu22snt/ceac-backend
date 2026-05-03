package com.br.ceac.repository;

import com.br.ceac.model.Veiculo;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT t FROM Veiculo t WHERE " +
            "LOWER(t.placa) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.modelo) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.tipo) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.cor) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Veiculo> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
