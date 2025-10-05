package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionToViewListDto;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;

@RestController
@RequestMapping("/api/division")
public class DivisionController {
    @Autowired
	private  DivisionService divisionService;


    @GetMapping
	public List<DivisionToViewListDto> getAllDivisiones() {
		return divisionService.findAll();
	}
	
	// Borrar división
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        divisionService.delete(id);
    }

    // Habilitar división
    @PutMapping("/habilitar/{id}")
    public DivisionToViewListDto habilitar(@PathVariable Long id) {
        return divisionService.habilitar(id);
    }

    // Deshabilitar división
    @PutMapping("/deshabilitar/{id}")
    public DivisionToViewListDto deshabilitar(@PathVariable Long id) {
        return divisionService.deshabilitar(id);
    }


}
