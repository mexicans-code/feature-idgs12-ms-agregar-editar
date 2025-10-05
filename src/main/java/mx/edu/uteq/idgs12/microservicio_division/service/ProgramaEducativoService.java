package mx.edu.uteq.idgs12.microservicio_division.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;

@Service
public class ProgramaEducativoService {
@Autowired
    private ProgramaEducativoRepository programaEducativoRepository;

    @Autowired
    private DivisionRepository divisionRepository;
 // Listar todos los programas educativos
    public List<ProgramaEducativoToViewListDto> findAll() {
        List<ProgramaEducativo> programas = programaEducativoRepository.findAll();
        List<ProgramaEducativoToViewListDto> resultado = new ArrayList<>();

        for (ProgramaEducativo programa : programas) {
            ProgramaEducativoToViewListDto dto = new ProgramaEducativoToViewListDto();
            dto.setProgramaId(programa.getId());
            dto.setPrograma(programa.getPrograma());
            dto.setActivo(programa.isActivo());

            if (programa.getDivision() != null) {
                dto.setDivisionNombre(programa.getDivision().getNombre());
                dto.setDivisionId(programa.getDivision().getId());
            }

            resultado.add(dto);
        }

        return resultado;
    }

    // Buscar un programa educativo por ID
    public ProgramaEducativoToViewListDto findById(Long id) {
        ProgramaEducativo programa = programaEducativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa Educativo no encontrado con ID: " + id));

        ProgramaEducativoToViewListDto dto = new ProgramaEducativoToViewListDto();
        dto.setProgramaId(programa.getId());
        dto.setPrograma(programa.getPrograma());
        dto.setActivo(programa.isActivo());

        if (programa.getDivision() != null) {
            dto.setDivisionNombre(programa.getDivision().getNombre());
            dto.setDivisionId(programa.getDivision().getId());
        }

        return dto;
    }

}
