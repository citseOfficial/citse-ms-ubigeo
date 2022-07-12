package com.ubigeo.citse.service;

import com.ubigeo.citse.entity.Departamento;

import java.util.List;

public interface DepartamentoService {
    public List<Departamento> findAll();

    public Departamento findById(int id);
    public List<Departamento> findByNoDepartamento(String noDepartamento);

}
