package com.pruebaTecnicaBack.empleados.service;

import com.pruebaTecnicaBack.empleados.dto.EmpleadoDTO;
import com.pruebaTecnicaBack.empleados.model.Departamento;
import com.pruebaTecnicaBack.empleados.model.Empleado;
import com.pruebaTecnicaBack.empleados.repository.DepartamentoRepository;
import com.pruebaTecnicaBack.empleados.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    @Override
    @Transactional
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO) {
        Departamento departamento = departamentoRepository.findById(empleadoDTO.getDepartamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
        
        Empleado empleado = Empleado.builder()
                .name(empleadoDTO.getName())
                .lastName(empleadoDTO.getLastName())
                .departamento(departamento)
                .build();
        
        Empleado savedEmpleado = empleadoRepository.save(empleado);
        
        return toDTO(savedEmpleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoDTO> getEmpleadosByDepartamento(Long departamentoId) {
        return empleadoRepository.findByDepartamentoId(departamentoId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoDTO getEmpleadoById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        return toDTO(empleado);
    }

    @Override
    @Transactional
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public EmpleadoDTO updateEmpleado(Long id, EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        
        Departamento departamento = departamentoRepository.findById(empleadoDTO.getDepartamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
        
        empleado.setName(empleadoDTO.getName());
        empleado.setLastName(empleadoDTO.getLastName());
        empleado.setDepartamento(departamento);
        
        Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return toDTO(updatedEmpleado);
    }

    private EmpleadoDTO toDTO(Empleado empleado) {
        return EmpleadoDTO.builder()
                .id(empleado.getId())
                .name(empleado.getName())
                .lastName(empleado.getLastName())
                .departamentoId(empleado.getDepartamento().getId())
                .build();
    }
}