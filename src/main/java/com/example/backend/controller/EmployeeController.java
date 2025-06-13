package com.example.backend.controller;

import com.example.backend.dto.EmployeeDTO;
import com.example.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDTO dto) {
        service.save(dto);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return service.getAll();
    }
}
