package com.idgs12.idgs12.dto;

import lombok.Data;

@Data
public class ProgramaEducativoToViewListDto {
    private Long programaId;
    private String programa;
    private boolean activo;
    private String divisionNombre;
    private Long divisionId;
}
