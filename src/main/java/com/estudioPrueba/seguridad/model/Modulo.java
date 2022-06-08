package com.estudioPrueba.seguridad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seg_modulo")
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1851917499877919651L;
    @Id
    @Column(name = "cod_modulo", nullable = false, length = 16)
    private String pk;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "estado", nullable = false, length = 3)
    private String estado;

    @Column(name = "version", nullable = false)
    private Integer version;

    @OneToMany(mappedBy = "modulo")
    private List<Funcionalidad> funcionalidades;

}