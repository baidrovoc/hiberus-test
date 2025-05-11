package com.example.employees.services;

import com.example.employees.dto.DepartmentDTO;
import com.example.employees.entity.Department;
import com.example.employees.mapper.DepartmentMapper;
import com.example.employees.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(DepartmentMapper::toDTO)
                .orElse(null);
    }

    public DepartmentDTO saveDepartment(DepartmentDTO dto) {
        Department saved = departmentRepository.save(DepartmentMapper.toEntity(dto));
        return DepartmentMapper.toDTO(saved);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    // Crear nuevo departamento
    public DepartmentDTO create(DepartmentDTO dto) {
        Department department = DepartmentMapper.toEntity(dto);
        department.setDepartmentStatus("A");
        Department saved = departmentRepository.save(department);
        return DepartmentMapper.toDTO(saved);
    }

    // Eliminación lógica
    public void logicalDelete(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Departamento no encontrado"));

        department.setDepartmentStatus("I");
        departmentRepository.save(department);
    }
}
