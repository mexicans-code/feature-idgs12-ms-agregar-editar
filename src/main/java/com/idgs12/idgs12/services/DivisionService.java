package com.idgs12.idgs12.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idgs12.idgs12.dto.DivisionToCreateDto;
import com.idgs12.idgs12.dto.DivisionToUpdateDto;
import com.idgs12.idgs12.dto.DivisionToViewListDto;
import com.idgs12.idgs12.entity.DivisionEntity;
import com.idgs12.idgs12.entity.ProgramaEducativo;
import com.idgs12.idgs12.repository.DivisionRepository;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    // --- Crear una nueva división ---
    public DivisionToViewListDto create(DivisionToCreateDto dto) {
        DivisionEntity entity = new DivisionEntity();
        entity.setNombre(dto.getNombre());
        entity.setImage(dto.getImage());
        entity.setActivo(dto.getActivo());

        DivisionEntity saved = divisionRepository.save(entity);

        DivisionToViewListDto resultado = new DivisionToViewListDto();
        resultado.setDivisionId(saved.getId());
        resultado.setNombre(saved.getNombre());
        resultado.setProgramasEducativos(new ArrayList<>());

        return resultado;
    }

    // --- Actualizar una división existente ---
    public DivisionToViewListDto update(Long id, DivisionToUpdateDto dto) {
        DivisionEntity division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + id));

        division.setNombre(dto.getNombre());
        division.setImage(dto.getImage());
        division.setActivo(dto.getActivo());

        DivisionEntity updated = divisionRepository.save(division);

        DivisionToViewListDto resultado = new DivisionToViewListDto();
        resultado.setDivisionId(updated.getId());
        resultado.setNombre(updated.getNombre());

        if (updated.getProgramaEducativo() != null) {
            var programas = new ArrayList<String>();
            for (ProgramaEducativo prog : updated.getProgramaEducativo()) {
                programas.add(prog.getPrograma());
            }
            resultado.setProgramasEducativos(programas);
        } else {
            resultado.setProgramasEducativos(new ArrayList<>());
        }

        return resultado;
    }
}
