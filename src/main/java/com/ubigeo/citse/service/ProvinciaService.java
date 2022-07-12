package com.ubigeo.citse.service;

import com.ubigeo.citse.entity.Departamento;
import com.ubigeo.citse.entity.Provincia;

import java.util.List;

public interface ProvinciaService {
    public List<Provincia> findAll();

    public Provincia findById(int id);
    public List<Provincia> findByNoProvincia(String noProvincia);
    public List<Provincia> findByDepartamento(Departamento departamento);
}
