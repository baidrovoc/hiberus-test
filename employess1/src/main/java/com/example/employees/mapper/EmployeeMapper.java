package com.example.employees.mapper;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.entity.Department;
import com.example.employees.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmployeeLastName(employee.getEmployeeLastName());
        dto.setAge(employee.getAge());
        dto.setSalary(employee.getSalary());
        dto.setInitDate(employee.getInitDate());
        dto.setEndDate(employee.getEndDate());
        dto.setEmployeeStatus(employee.getEmployeeStatus());
        if (employee.getDepartment() != null) {
            dto.setDepartmentId(employee.getDepartment().getId());
        }
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto, Department department) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmployeeLastName(dto.getEmployeeLastName());
        employee.setAge(dto.getAge());
        employee.setSalary(dto.getSalary());
        employee.setInitDate(dto.getInitDate());
        employee.setEndDate(dto.getEndDate());
        employee.setEmployeeStatus(dto.getEmployeeStatus());
        employee.setDepartment(department);
        return employee;
    }
}

