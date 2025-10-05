package com.idgs12.idgs12.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.idgs12.idgs12.dto.DivisionToCreateDto;
import com.idgs12.idgs12.dto.DivisionToUpdateDto;
import com.idgs12.idgs12.dto.DivisionToViewListDto;
import com.idgs12.idgs12.services.DivisionService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    // --- Agregar división ---
    @PostMapping("/divisiones")
    public DivisionToViewListDto create(@RequestBody DivisionToCreateDto dto) {
        return divisionService.create(dto);
    }

    // --- Editar división ---
    @PutMapping("/divisiones/{id}")
    public DivisionToViewListDto update(@PathVariable Long id, @RequestBody DivisionToUpdateDto dto) {
        return divisionService.update(id, dto);
    }
}
