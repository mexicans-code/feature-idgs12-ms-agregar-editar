package mx.edu.uteq.idgs12.microservicio_division.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;

@Service
public class ProgramaEducativoService {

    @Autowired
    private ProgramaEducativoRepository programaEducativoRepository;
    
    // Eliminar un programa educativo
    public void delete(Long id) {
        if (!programaEducativoRepository.existsById(id)) {
            throw new RuntimeException("Programa Educativo no encontrado con ID: " + id);
        }
        programaEducativoRepository.deleteById(id);
    }

    
}
