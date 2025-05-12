package com.example.employees.mapper;

import com.example.employees.dto.DepartmentDTO;
import com.example.employees.entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO toDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setDepartmentStatus(department.getDepartmentStatus());
        return dto;
    }

    public static Department toEntity(DepartmentDTO dto) {
        Department department = new Department();
        department.setId(dto.getId()); // Puede omitirse si usas @GeneratedValue
        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentStatus(dto.getDepartmentStatus());
        return department;
    }
}
