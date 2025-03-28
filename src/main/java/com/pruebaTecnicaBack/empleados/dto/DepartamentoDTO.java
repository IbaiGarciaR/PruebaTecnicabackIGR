package com.pruebaTecnicaBack.empleados.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartamentoDTO {
    private Long id;
    private String name;
}