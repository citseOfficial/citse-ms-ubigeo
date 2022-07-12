package com.ubigeo.citse.service.serviceImp;

import com.ubigeo.citse.dao.ProvinciaDao;
import com.ubigeo.citse.entity.Departamento;
import com.ubigeo.citse.entity.Provincia;
import com.ubigeo.citse.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvinciaServiceImp implements ProvinciaService {

    @Autowired
    private ProvinciaDao repo;

    @Override
    @Transactional(readOnly = true)
    public List<Provincia> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Provincia findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Provincia> findByNoProvincia(String noProvincia){
        return repo.findTop10ByNoProvinciaContains(noProvincia);
    }

    @Override
    public List<Provincia> findByDepartamento(Departamento departamento){
        return repo.findByDepartamento(departamento);
    }

}
