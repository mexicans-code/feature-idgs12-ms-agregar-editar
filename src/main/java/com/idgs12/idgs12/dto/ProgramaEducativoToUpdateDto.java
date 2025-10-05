package com.idgs12.idgs12.dto;

import lombok.Data;

@Data
public class ProgramaEducativoToUpdateDto {
    private String programa;
    private boolean activo;
    private Long divisionId;
}