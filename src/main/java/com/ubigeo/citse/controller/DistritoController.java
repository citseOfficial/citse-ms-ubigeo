package com.ubigeo.citse.controller;

import com.ubigeo.citse.entity.Distrito;
import com.ubigeo.citse.entity.Provincia;
import com.ubigeo.citse.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("distrito")
public class DistritoController {

    @Autowired
    private DistritoService service;

    @GetMapping
    public ResponseEntity<List<Distrito>> findAll(@RequestParam(name = "nombre",required = false)String nombre,
                                                  @RequestParam(name = "provincia",required = false)Integer provincia) {

        List<Distrito> distritos = new ArrayList<>();
        if(provincia==null && nombre==null){
            distritos = service.findAll();
            if(distritos.isEmpty())
                return ResponseEntity.noContent().build();
        }else if(nombre!=null){
            distritos=service.findTop10ByNoDistritoContains(nombre);
            if(distritos.isEmpty())
                return ResponseEntity.notFound().build();
        }else {
            distritos=service.findByProvincia(Provincia.builder().id(provincia).build());
            if(distritos.isEmpty())
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(distritos);
    }

    @GetMapping("/{id}")
    public Distrito findById(@PathVariable Integer id){
        return service.findById(id);
    }
}
