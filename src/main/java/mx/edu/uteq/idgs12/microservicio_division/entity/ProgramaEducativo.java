package mx.edu.uteq.idgs12.microservicio_division.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "programas_educativos")
public class ProgramaEducativo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String programa;
    private boolean activo;
}