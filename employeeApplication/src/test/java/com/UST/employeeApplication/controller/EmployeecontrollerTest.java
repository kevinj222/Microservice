package com.UST.employeeApplication.controller;

import com.UST.employeeApplication.entity.Employee;
import com.UST.employeeApplication.service.Employeeservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Employeecontroller.class)
class EmployeecontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Employeeservice mockEmployeeservice;

    @Test
    void testRegister() throws Exception {
        // Setup
        // Configure Employeeservice.createEmployee(...).
        final Employee employee = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        when(mockEmployeeservice.createEmployee(
                new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr"))).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/register")
                        .content(asJsonString(employee)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Employee employee) {
        try{
            return new ObjectMapper().writeValueAsString(employee);

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void testGetALLEmployee() throws Exception {
        // Setup
        // Configure Employeeservice.getALLEmployee(...).
        final List<Employee> employees = List.of(
                new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr"));
        when(mockEmployeeservice.getALLEmployee()).thenReturn(employees);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetALLEmployee_EmployeeserviceReturnsNoItems() throws Exception {
        // Setup
        when(mockEmployeeservice.getALLEmployee()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetEmployeeById() throws Exception {
        // Setup
        // Configure Employeeservice.getEmployeeByempId(...).
        final Employee employee = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        when(mockEmployeeservice.getEmployeeByempId("empId")).thenReturn(employee);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/employees/{empId}", "empId")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteEmployee() throws Exception {
        // Setup
        when(mockEmployeeservice.deleteEmployeeByempId("empId")).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/deleteemployee/{empId}", "empId")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
