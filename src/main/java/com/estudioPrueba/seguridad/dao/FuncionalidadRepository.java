package com.estudioPrueba.seguridad.dao;

import com.estudioPrueba.seguridad.model.Funcionalidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionalidadRepository extends JpaRepository<Funcionalidad, Integer> {
}