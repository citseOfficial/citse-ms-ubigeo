package com.ubigeo.citse.controller;

import com.ubigeo.citse.entity.Departamento;
import com.ubigeo.citse.service.DepartamentoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("departamento")
@Api(value = "Gestion de departamentos", description = "Microservicio de departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public ResponseEntity<List<Departamento>> findAll(@RequestParam(name = "nombre",required = false) String nombre){
        List<Departamento> dep = new ArrayList<>();
        if(null==nombre){
            dep=service.findAll();
            if(dep.isEmpty())
                return ResponseEntity.noContent().build();
        }else{
            dep=service.findByNoDepartamento(nombre);
            if(dep.isEmpty())
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dep);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Departamento findById(@PathVariable Integer id,HttpRequestHandlerServlet request){
        return service.findById(id);
    }
}
