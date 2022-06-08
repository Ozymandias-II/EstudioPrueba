package com.estudioPrueba.seguridad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seg_perfil")
public class Perfil implements Serializable {
    private static final long serialVersionUID = 507024126194119122L;
    @Id
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "estado", nullable = false, length = 3)
    private String estado;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    private Instant audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String funcionalidades;

    @Column(name = "version", nullable = false)
    private Integer version;

    @OneToMany(mappedBy = "segPerfil")
    private Set<UsuarioPerfil> usuarioPerfiles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "segPerfil")
    private Set<PerfilFuncionalidad> segPerfilFuncionalidads = new LinkedHashSet<>();

}