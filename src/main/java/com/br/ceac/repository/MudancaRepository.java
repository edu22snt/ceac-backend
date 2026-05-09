package com.br.ceac.repository;

import com.br.ceac.model.Mudanca;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MudancaRepository extends JpaRepository<Mudanca, Long> {

    @Query("SELECT t FROM Mudanca t WHERE " +
            "LOWER(t.tipo) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.morador.unidade.bloco) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.morador.unidade.apartamento) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.morador.nome) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.morador.telefone) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.morador.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Mudanca> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

}
