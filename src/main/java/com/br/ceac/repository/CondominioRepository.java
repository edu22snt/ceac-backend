package com.br.ceac.repository;

import com.br.ceac.model.Condominio;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    @Query("SELECT c FROM Condominio c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :param, '%')) " +
            "OR LOWER(c.endereco) LIKE LOWER(CONCAT('%', :param, '%'))")
    Page<Condominio> searchByKeyword(@Param("param") String param, Pageable pageable);
}
