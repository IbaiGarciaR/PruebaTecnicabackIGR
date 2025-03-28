package com.pruebaTecnicaBack.empleados.controller;

import com.pruebaTecnicaBack.empleados.dto.EmpleadoDTO;
import com.pruebaTecnicaBack.empleados.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.createEmpleado(empleadoDTO);
    }

    @GetMapping("/departamento/{departamentoId}")
    public List<EmpleadoDTO> getEmpleadosByDepartamento(@PathVariable Long departamentoId) {
        return empleadoService.getEmpleadosByDepartamento(departamentoId);
    }

    @GetMapping("/{id}")
    public EmpleadoDTO getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }

    @PutMapping("/{id}")
    public EmpleadoDTO updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.updateEmpleado(id, empleadoDTO);
    }
}