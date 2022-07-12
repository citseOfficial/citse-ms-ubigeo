package com.ubigeo.citse.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "TMA_DISTRITOS")
@Entity
public class Distrito implements Serializable {

    @Id
    @Column(name = "ID_DISTRITO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NO_DISTRITO")
    private String noDistrito;

    @ManyToOne
    @JoinColumn(name = "ID_PROVINCIA")
    private Provincia provincia;
}
