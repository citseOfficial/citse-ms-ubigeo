package com.ubigeo.citse.controller;

import com.ubigeo.citse.entity.Departamento;
import com.ubigeo.citse.entity.Provincia;
import com.ubigeo.citse.service.ProvinciaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("provincia")
@Api(value = "Gestion de provincia", description = "Microservicio de provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaService service;

    @GetMapping
    public ResponseEntity<List<Provincia>> findAll(@RequestParam(name = "nombre",required = false)String nombre,
                                                   @RequestParam(name = "departamento",required = false)Integer departamento){
        List<Provincia> pv = new ArrayList<>();
        if(nombre==null && departamento==null){
            pv=service.findAll();
            if(pv.isEmpty())
                return ResponseEntity.noContent().build();
        }else if(nombre!=null){
            pv=service.findByNoProvincia(nombre);
            if (pv.isEmpty())
                return ResponseEntity.notFound().build();
        }else{
            pv=service.findByDepartamento(Departamento.builder().id(departamento).build());
            if(pv.isEmpty())
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pv);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Provincia findById(@PathVariable Integer id, HttpRequestHandlerServlet request){
        return service.findById(id);
    }
}
