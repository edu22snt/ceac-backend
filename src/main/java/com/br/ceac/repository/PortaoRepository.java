package com.br.ceac.repository;

import com.br.ceac.model.Portao;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PortaoRepository extends JpaRepository<Portao, Long> {

    @Query("SELECT t FROM Portao t WHERE " +
            "LOWER(t.nome) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Portao> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
