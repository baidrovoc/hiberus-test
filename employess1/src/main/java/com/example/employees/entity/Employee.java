package com.example.employees.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private double salary;

    @Column(name = "init_date")
    private LocalDate initDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "employee_status")
    private String employeeStatus;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
