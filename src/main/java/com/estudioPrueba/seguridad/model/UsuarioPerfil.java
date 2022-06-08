package com.estudioPrueba.seguridad.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "seg_usuario_perfil")
public class UsuarioPerfil implements Serializable {
    private static final long serialVersionUID = 2084480751334597191L;
    @EmbeddedId
    private UsuarioPerfilPk pk;

    @MapsId("codUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_usuario", nullable = false)
    @ToString.Exclude
    private Usuario codUsuario;

    @MapsId("codPerfil")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_perfil", nullable = false)
    @ToString.Exclude
    private Perfil codPerfil;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    private Instant audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Column(name = "version", nullable = false)
    private Integer version;

    public UsuarioPerfil(UsuarioPerfilPk pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioPerfil that = (UsuarioPerfil) o;
        return pk != null && Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk);
    }
}