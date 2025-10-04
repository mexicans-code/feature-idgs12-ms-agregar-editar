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

}
