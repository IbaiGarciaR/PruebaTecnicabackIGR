package com.pruebaTecnicaBack.empleados.repository;

import com.pruebaTecnicaBack.empleados.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}