package com.ubigeo.citse.service.serviceImp;

import com.ubigeo.citse.dao.DistritoDao;
import com.ubigeo.citse.entity.Distrito;
import com.ubigeo.citse.entity.Provincia;
import com.ubigeo.citse.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistritoServiceImp implements DistritoService {

    @Autowired
    private DistritoDao repo;

    @Override
    @Transactional(readOnly = true)
    public List<Distrito> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Distrito findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Distrito> findTop10ByNoDistritoContains(String noDistrito){
        return repo.findTop10ByNoDistritoContains(noDistrito);
    }

    @Override
    public List<Distrito> findByProvincia(Provincia provincia){
        return repo.findByProvincia(provincia);
    }
}
