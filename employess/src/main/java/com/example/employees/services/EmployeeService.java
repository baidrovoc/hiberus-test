package com.example.employees.services;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.entity.Department;
import com.example.employees.entity.Employee;
import com.example.employees.mapper.EmployeeMapper;
import com.example.employees.repository.DepartmentRepository;
import com.example.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDTO)
                .toList();
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO)
                .orElse(null);
    }

    public EmployeeDTO create(Long departmentId, EmployeeDTO dto) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Departamento no encontrado"));

        Employee employee = employeeMapper.toEntity(dto, department);
        employee.setEmployeeStatus("A");
        employee.setInitDate(LocalDate.now());

        Employee saved = employeeRepository.save(employee);
        return employeeMapper.toDTO(saved);
    }

    public void logicalDelete(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        employee.setEmployeeStatus("I");
        employeeRepository.save(employee);
    }

    public EmployeeDTO findHighestSalary() {
        return employeeRepository.findAll().stream()
                .filter(e -> "A".equalsIgnoreCase(e.getEmployeeStatus()))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .map(employeeMapper::toDTO)
                .orElse(null);
    }

    public EmployeeDTO findYoungestEmployee() {
        return employeeRepository.findAll().stream()
                .filter(e -> "A".equalsIgnoreCase(e.getEmployeeStatus()))
                .min(Comparator.comparingInt(Employee::getAge))
                .map(employeeMapper::toDTO)
                .orElse(null);
    }

    public Long countEmployeesLastMonth() {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return employeeRepository.findAll().stream()
                .filter(e -> e.getInitDate() != null && e.getInitDate().isAfter(oneMonthAgo))
                .count();
    }
}
