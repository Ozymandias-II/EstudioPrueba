package com.estudioPrueba.seguridad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "seg_registro_sesion")
public class RegistroSesion implements Serializable {
    private static final long serialVersionUID = 8719770944135840170L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "secuencia", nullable = false)
    private Integer id;

    @Column(name = "cod_usuario", nullable = false, length = 32)
    private String codUsuario;

    @Column(name = "fecha_conexion", nullable = false)
    private Instant fechaConexion;

    @Column(name = "ip_conexion", nullable = false, length = 30)
    private String ipConexion;

    @Column(name = "resultado", nullable = false, length = 3)
    private String resultado;

    @Column(name = "error", length = 5)
    private String error;

}