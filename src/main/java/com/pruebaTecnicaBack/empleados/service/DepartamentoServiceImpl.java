package com.pruebaTecnicaBack.empleados.service;

import com.pruebaTecnicaBack.empleados.dto.DepartamentoDTO;
import com.pruebaTecnicaBack.empleados.model.Departamento;
import com.pruebaTecnicaBack.empleados.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    @Override
    public DepartamentoDTO createDepartamento(DepartamentoDTO departamentoDTO) {
        Departamento departamento = Departamento.builder()
                .name(departamentoDTO.getName())
                .build();
        
        Departamento savedDepartamento = departamentoRepository.save(departamento);
        
        return DepartamentoDTO.builder()
                .id(savedDepartamento.getId())
                .name(savedDepartamento.getName())
                .build();
    }
}