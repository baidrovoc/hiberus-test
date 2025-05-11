package com.example.employees.controller;

import com.example.employees.dto.DepartmentDTO;
import com.example.employees.services.DepartmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    public void shouldCreateDepartment() throws Exception {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentName("Finanzas");
        departmentDTO.setDepartmentStatus("A");

        Mockito.when(departmentService.create(Mockito.any(DepartmentDTO.class))).thenReturn(departmentDTO);

        String json = """
            {
              "departmentName": "Finanzas",
              "departmentStatus": "A"
            }
        """;

        mockMvc.perform(post("/department/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value("Finanzas"))
                .andExpect(jsonPath("$.departmentStatus").value("A"));
    }

    @Test
    public void shouldDeleteDepartmentLogically() throws Exception {
        Long departmentId = 1L;

        Mockito.doNothing().when(departmentService).logicalDelete(departmentId);

        mockMvc.perform(post("/department/delete/{id}", departmentId))
                .andExpect(status().isOk())
                .andExpect(content().string("Departamento eliminado lógicamente"));
    }
}
