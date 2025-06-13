package com.example.backend.service;

import com.example.backend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void save(EmployeeDTO dto);
    List<EmployeeDTO> getAll();
}
