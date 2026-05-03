package com.br.ceac.repository;

import com.br.ceac.model.Morador;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

    @Query("SELECT t FROM Morador t WHERE " +
            "LOWER(t.nome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.telefone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.veiculo.placa) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Morador> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
