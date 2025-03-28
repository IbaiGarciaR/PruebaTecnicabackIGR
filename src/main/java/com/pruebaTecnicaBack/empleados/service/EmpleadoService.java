package com.pruebaTecnicaBack.empleados.service;

import com.pruebaTecnicaBack.empleados.dto.EmpleadoDTO;
import java.util.List;

public interface EmpleadoService {
    EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO);
    List<EmpleadoDTO> getEmpleadosByDepartamento(Long departamentoId);
    EmpleadoDTO getEmpleadoById(Long id);
    void deleteEmpleado(Long id);
    EmpleadoDTO updateEmpleado(Long id, EmpleadoDTO empleadoDTO);
}