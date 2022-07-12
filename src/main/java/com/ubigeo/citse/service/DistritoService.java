package com.ubigeo.citse.service;

import com.ubigeo.citse.entity.Distrito;
import com.ubigeo.citse.entity.Provincia;

import java.util.List;

public interface DistritoService {
    public List<Distrito> findAll();
    public Distrito findById(int id);
    //-- otros usos
    public List<Distrito> findTop10ByNoDistritoContains(String noDistrito);
    public List<Distrito> findByProvincia(Provincia provincia);


}
