package com.pruebaTecnicaBack.empleados.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDTO {
    private Long id;
    private String name;
    private String lastName;
    private Long departamentoId;
}