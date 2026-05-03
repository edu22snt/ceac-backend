package com.br.ceac.repository;

import com.br.ceac.model.ControleAcesso;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControleAcessoRepository extends JpaRepository<ControleAcesso, Long> {

    @Query("""
        SELECT v FROM ControleAcesso v
        WHERE LOWER(v.portao) LIKE LOWER(CONCAT('%', :keyword, '%')) AND v.tag = :keyword
    """)
    Page<ControleAcesso> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
