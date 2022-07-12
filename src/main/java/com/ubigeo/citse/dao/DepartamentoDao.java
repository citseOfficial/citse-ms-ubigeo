package com.ubigeo.citse.dao;

import com.ubigeo.citse.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoDao extends JpaRepository<Departamento,Integer> {
    /*
    @Query("SELECT d FROM Departamento d WHERE (noDepartamento like %:query% or id like %:query%)")
    List<Banco> findAll(String query, Sort sort);

    @Query("SELECT d FROM Departamento d WHERE (noDepartamento like %:query% or id like %:query%)")
    Page<Banco> findAllParams(String query, Pageable pageable);
* */

    public List<Departamento> findTop10ByNoDepartamentoContains(String noDepartamento);
}
