package com.estudioPrueba.seguridad.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "seg_funcionalidad")
public class Funcionalidad implements Serializable {
    private static final long serialVersionUID = -7660623537657200829L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_funcionalidad", nullable = false)
    private Integer pk;

    @Column(name = "url_principal", nullable = false, length = 200)
    private String urlPrincipal;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 3)
    private String estado;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    private Instant audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Column(name = "version", nullable = false)
    private Integer version;

    @JoinColumn(name = "cod_modulo", referencedColumnName = "cod_modulo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modulo modulo;

    @OneToMany(mappedBy = "funcionalidad")
    @ToString.Exclude
    private List<PerfilFuncionalidad> perfilFuncionalidades;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Funcionalidad that = (Funcionalidad) o;
        return pk != null && Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}