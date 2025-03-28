package com.pruebaTecnicaBack.empleados.repository;

import com.pruebaTecnicaBack.empleados.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>, JpaSpecificationExecutor<Empleado> {

	List<Empleado> findByDepartamentoId(Long departamentoId);
}