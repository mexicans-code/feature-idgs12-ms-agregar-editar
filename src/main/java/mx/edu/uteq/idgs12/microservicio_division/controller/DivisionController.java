package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


}
