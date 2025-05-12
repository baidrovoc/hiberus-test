package com.example.employees.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;
    private String employeeName;
    private String employeeLastName;
    private int age;
    private double salary;
    private LocalDate initDate;
    private LocalDate endDate;
    private String employeeStatus;
    private Long departmentId;
}

