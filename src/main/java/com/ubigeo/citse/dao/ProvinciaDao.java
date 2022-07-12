package com.ubigeo.citse.dao;

import com.ubigeo.citse.entity.Departamento;
import com.ubigeo.citse.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaDao extends JpaRepository<Provincia,Integer> {
    public List<Provincia> findTop10ByNoProvinciaContains(String noProvincia);
    public List<Provincia> findByDepartamento(Departamento departamento);
}
