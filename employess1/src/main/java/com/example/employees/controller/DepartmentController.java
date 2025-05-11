package com.example.employees.controller;

import com.example.employees.dto.DepartmentDTO;
import com.example.employees.dto.EmployeeDTO;
import com.example.employees.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    // Crea un nuevo registro para departamentos
    @PostMapping("/create")
    public ResponseEntity<DepartmentDTO> create(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO created = departmentService.create(departmentDTO);
        return ResponseEntity.ok(created);
    }

    // Elimina de manera lógica un registro de departamento
    @PostMapping("/delete/{departmentId}")
    public ResponseEntity<String> delete(@PathVariable Long departmentId) {
        departmentService.logicalDelete(departmentId);
        return ResponseEntity.ok("Departamento eliminado lógicamente");
    }

    @GetMapping("/AllDepartments")
    public ResponseEntity<List<DepartmentDTO>> getAll() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
}
