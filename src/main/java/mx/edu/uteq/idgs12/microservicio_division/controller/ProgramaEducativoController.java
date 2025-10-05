package mx.edu.uteq.idgs12.microservicio_division.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.edu.uteq.idgs12.microservicio_division.service.ProgramaEducativoService;


@RestController
@RequestMapping("/api")
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoService programaEducativoService;

     @DeleteMapping("/programas/{id}")
    public void delete(@PathVariable Long id) {
        programaEducativoService.delete(id);
    }

    
    
}
