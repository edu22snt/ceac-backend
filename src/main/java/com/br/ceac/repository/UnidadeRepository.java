package com.br.ceac.repository;

import com.br.ceac.model.Unidade;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    @Query("SELECT c FROM Unidade c WHERE LOWER(c.apartamento) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.bloco) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Unidade> searchByKeyword(@Param("param") String param, Pageable pageable);



}
