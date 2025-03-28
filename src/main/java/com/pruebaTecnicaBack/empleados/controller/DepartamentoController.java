package com.pruebaTecnicaBack.empleados.controller;

import com.pruebaTecnicaBack.empleados.dto.DepartamentoDTO;
import com.pruebaTecnicaBack.empleados.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoDTO createDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        return departamentoService.createDepartamento(departamentoDTO);
    }
}