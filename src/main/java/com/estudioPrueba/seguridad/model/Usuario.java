package com.estudioPrueba.seguridad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seg_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 8396663992695870332L;
    @Id
    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String id;

    @Column(name = "mail", nullable = false, length = 128)
    private String mail;

    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "clave", nullable = false, length = 64)
    private String clave;

    @Column(name = "estado", nullable = false, length = 3)
    private String estado;

    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "origen", nullable = false, length = 3)
    private String origen;

    @Column(name = "fecha_cambio_clave")
    private LocalDate fechaCambioClave;

    @Column(name = "nro_intentos_fallidos", nullable = false, precision = 3)
    private BigDecimal nroIntentosFallidos;

    @Column(name = "fecha_ultima_sesion")
    private Instant fechaUltimaSesion;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    private Instant audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Column(name = "version", nullable = false)
    private Integer version;

    @OneToMany(mappedBy = "segUsuario")
    private Set<UsuarioPerfil> usuarioPerfils = new LinkedHashSet<>();

}