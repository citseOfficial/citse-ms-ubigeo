package com.ubigeo.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TMA_PROVINCIAS")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Provincia implements Serializable {

    @Id
    @Column(name = "ID_PROVINCIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NO_PROVINCIA")
    private String noProvincia;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTAMENTO")
    private Departamento departamento;

    @JsonIgnore
    @OneToMany(mappedBy = "provincia")
    private List<Distrito> distritos;
}
