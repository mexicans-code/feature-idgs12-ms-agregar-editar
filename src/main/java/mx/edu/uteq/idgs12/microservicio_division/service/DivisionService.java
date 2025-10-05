package mx.edu.uteq.idgs12.microservicio_division.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;

@Service
public class DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    
    // Listar todas las divisiones
    public List<DivisionToViewListDto> findAll() {
        List<DivisionEntity> divisiones = divisionRepository.findAll();
        List<DivisionToViewListDto> resultado = new ArrayList<>();
        for (DivisionEntity division : divisiones) {
            DivisionToViewListDto dto = new DivisionToViewListDto();
            dto.setDivisionId(division.getId());
            dto.setNombre(division.getNombre());
            if (division.getProgramaEducativo() != null) {
                List<String> programas = new ArrayList<>();
                for (ProgramaEducativo prog : division.getProgramaEducativo()) {
                    programas.add(prog.getPrograma());
                }
                dto.setProgramasEducativos(programas);
            } else {
                dto.setProgramasEducativos(new ArrayList<>());
            }
            resultado.add(dto);
        }
        return resultado;
    }

    // Buscar una división por ID
    public DivisionToViewListDto findById(Long id) {
        DivisionEntity division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada con ID: " + id));

        DivisionToViewListDto dto = new DivisionToViewListDto();
        dto.setDivisionId(division.getId());
        dto.setNombre(division.getNombre());

        if (division.getProgramaEducativo() != null) {
            List<String> programas = new ArrayList<>();
            for (ProgramaEducativo prog : division.getProgramaEducativo()) {
                programas.add(prog.getPrograma());
            }
            dto.setProgramasEducativos(programas);
        } else {
            dto.setProgramasEducativos(new ArrayList<>());
        }

        return dto;
    }

    
}
