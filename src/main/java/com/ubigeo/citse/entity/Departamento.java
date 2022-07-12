package com.ubigeo.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TMA_DEPARTAMENTOS")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Departamento implements Serializable {

    @Id
    @Column(name = "ID_DEPARTAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NO_DEPARTAMENTO")
    private String noDepartamento;

    @JsonIgnore
    @OneToMany(mappedBy = "departamento")
    private List<Provincia> provincias;

}
