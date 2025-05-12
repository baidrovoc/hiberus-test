package com.example.employees.controller;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Crea un nuevo registro de empleado asociado a un departamento
    @PostMapping("/create/{departmentId}")
    public ResponseEntity<EmployeeDTO> create(@PathVariable Long departmentId, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.create(departmentId, employeeDTO));
    }

    // Elimina lógicamente un empleado
    @PostMapping("/delete/{employeeId}")
    public ResponseEntity<String> delete(@PathVariable Long employeeId) {
        employeeService.logicalDelete(employeeId);
        return ResponseEntity.ok("Empleado eliminado lógicamente");
    }

    // Devuelve el empleado con el salario más alto
    @GetMapping("/highestSalary")
    public ResponseEntity<EmployeeDTO> getHighestSalary() {
        return ResponseEntity.ok(employeeService.findHighestSalary());
    }

    // Devuelve el empleado más joven
    @GetMapping("/lowerAge")
    public ResponseEntity<EmployeeDTO> getLowerAge() {
        return ResponseEntity.ok(employeeService.findYoungestEmployee());
    }

    // Devuelve la cantidad de empleados que ingresaron en el último mes
    @GetMapping("/countLastMonth")
    public ResponseEntity<Long> countLastMonth() {
        return ResponseEntity.ok(employeeService.countEmployeesLastMonth());
    }

    // Opcional: obtener todos los empleados
    @GetMapping("/All")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
