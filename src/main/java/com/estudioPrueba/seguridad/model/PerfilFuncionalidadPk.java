package com.estudioPrueba.seguridad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PerfilFuncionalidadPk implements Serializable {
    private static final long serialVersionUID = -857331483188046925L;
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codPerfil;

    @Column(name = "cod_funcionalidad", nullable = false)
    private Integer codFuncionalidad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PerfilFuncionalidadPk entity = (PerfilFuncionalidadPk) o;
        return Objects.equals(this.codPerfil, entity.codPerfil) &&
                Objects.equals(this.codFuncionalidad, entity.codFuncionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPerfil, codFuncionalidad);
    }

}