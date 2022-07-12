package com.ubigeo.citse.service.serviceImp;

import com.ubigeo.citse.dao.DepartamentoDao;
import com.ubigeo.citse.entity.Departamento;
import com.ubigeo.citse.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImp implements DepartamentoService {

    @Autowired
    private DepartamentoDao repo;

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Departamento> findByNoDepartamento(String noDepartamento) {
        return repo.findTop10ByNoDepartamentoContains(noDepartamento);
    }
}
