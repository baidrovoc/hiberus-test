package com.example.employees.controller;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    // 1. Crear empleado
    @Test
    public void shouldCreateEmployee() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName("Brisbani");
        employeeDTO.setEmployeeLastName("Rodriguez");
        employeeDTO.setAge(30);
        employeeDTO.setSalary(750.0);

        Mockito.when(employeeService.create(Mockito.anyLong(), Mockito.any())).thenReturn(employeeDTO);

        String json = """
        {
            "employeeName": "Brisbani",
            "employeeLastName": "Rodriguez",
            "age": 30,
            "salary": 750.0
        }
        """;

        mockMvc.perform(post("/employee/create/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeName").value("Brisbani"));
    }

    // 2. Eliminar lógicamente
    @Test
    public void shouldDeleteEmployeeLogically() throws Exception {
        Mockito.doNothing().when(employeeService).logicalDelete(Mockito.anyLong());

        mockMvc.perform(post("/employee/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Empleado eliminado lógicamente"));
    }

    // 3. Mayor salario
    @Test
    public void shouldReturnHighestSalaryEmployee() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName("Maria");
        employeeDTO.setSalary(600.0);

        Mockito.when(employeeService.findHighestSalary()).thenReturn(employeeDTO);

        mockMvc.perform(get("/employee/highestSalary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeName").value("Maria"));
    }

    // 4. Menor edad
    @Test
    public void shouldReturnYoungestEmployee() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName("José");
        employeeDTO.setAge(20);

        Mockito.when(employeeService.findYoungestEmployee()).thenReturn(employeeDTO);

        mockMvc.perform(get("/employee/lowerAge"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeName").value("José"));
    }

    // 5. Contar ingresos último mes
    @Test
    public void shouldCountEmployeesLastMonth() throws Exception {
        Mockito.when(employeeService.countEmployeesLastMonth()).thenReturn(2L);

        mockMvc.perform(get("/employee/countLastMonth"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }
}
